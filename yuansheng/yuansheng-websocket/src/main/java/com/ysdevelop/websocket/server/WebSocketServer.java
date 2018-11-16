package com.ysdevelop.websocket.server;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ysdevelop.mq.server.MessageProducer;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
@Component
public class WebSocketServer implements InitializingBean {

	// websocket端口
	public static final int WEBSOCKET_PORT = 9090;
	
	private Logger logger = Logger.getLogger(this.getClass());
	@Autowired
	private WebSocketServerHandler socketServerHandler;
	@Autowired
    private MessageProducer messageProducer ;
	
	
	public void run(int port) throws Exception {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap bootstrap = new ServerBootstrap();
			bootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<Channel>() {
				@Override
				protected void initChannel(Channel channel) throws Exception {
					ChannelPipeline pipeline = channel.pipeline();
					pipeline.addLast("http-codec", new HttpServerCodec());
					pipeline.addLast("aggregator", new HttpObjectAggregator(65536));
					pipeline.addLast("http-chunked", new ChunkedWriteHandler());
					pipeline.addLast("handler", socketServerHandler);

				}
			});
			Channel channel = bootstrap.bind(port).sync().channel();
			logger.info("websocket 已经启动,端口:"+port+".");
			channel.closeFuture().sync();
		} finally {
			bossGroup.shutdownGracefully();
			workerGroup.shutdownGracefully();
		}

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("spring application begin init websocket server...");
		//messageProducer.sendMessage("websocketmq","hello mq");
		run(WEBSOCKET_PORT);
	}

}
