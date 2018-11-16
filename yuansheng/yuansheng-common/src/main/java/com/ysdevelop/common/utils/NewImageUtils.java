package com.ysdevelop.common.utils;

import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * @author oldHuang
 * 
 * @Package com.ysdevelop.common.utils
 * 
 * @Description 图片合成工具
 * 
 * @Date 2018年6月7日
 * 
 * @Version
 * 
 */
public class NewImageUtils {
	/**
	 * 
	 * @Title: 构造图片
	 * @Description: 生成水印并返回java.awt.image.BufferedImage
	 * @param file
	 *            源文件(图片)
	 * @param waterFile
	 *            水印文件(图片)
	 * @param x
	 *            距离右下角的X偏移量
	 * @param y
	 *            距离右下角的Y偏移量
	 * @param alpha
	 *            透明度, 选择值从0.0~1.0: 完全透明~完全不透明
	 * @param savePath
	 *            保存路径
	 * @return BufferedImage
	 * @throws IOException
	 */
	public static void watermarkAndGenerateWaterFile(File file, File waterFile, String savePath, int x, int y, float alpha,Integer type)
			throws IOException {
		// 获取底图
		try {
			BufferedImage buffImg = ImageIO.read(file);
			// 获取层图
			BufferedImage waterImg = ImageIO.read(waterFile);
			// 创建Graphics2D对象，用在底图对象上绘图
			Graphics2D g2d = buffImg.createGraphics();
			int waterImgWidth = waterImg.getWidth();// 获取层图的宽度
			int waterImgHeight = waterImg.getHeight();// 获取层图的高度
			// 在图形和图像中实现混合和透明效果
			g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_ATOP, alpha));
			// 绘制
			if(type==2){
				waterImgWidth = waterImgWidth/2;
				waterImgHeight= waterImgHeight/2;
			}
			g2d.drawImage(waterImg, x, y, waterImgWidth, waterImgHeight, null);
			g2d.dispose();// 释放图形上下文使用的系统资源
			int temp = savePath.lastIndexOf(".") + 1;
			ImageIO.write(buffImg, savePath.substring(temp), new File(savePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//	 /**
//	 *
//	 * @param args
//	 * @throws IOException
//	 * IO异常直接抛出了
//	 * @author bls
//	 */
//	 public static void main(String[] args) throws IOException {
//	 String sourceFilePath =
//	 "C://Users//Admin//Desktop//qrCode-demo//backgroud.png";
//	 String waterFilePath = "H://QrCode//my.png";
//	 String saveFilePath = "H://QrCode//new.png";
//	 NewImageUtils newImageUtils = new NewImageUtils();
//	 // 构建叠加层
//	 BufferedImage buffImg = NewImageUtils.watermark(new File(sourceFilePath),
//	 new File(waterFilePath), 130, 200, 1.0f);
//	 // 输出水印图片
//	 newImageUtils.generateWaterFile(buffImg, saveFilePath);
//	 }

}
