package com.thinkingFruit.client.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkingFruit.client.entity.Agent;
import com.thinkingFruit.client.entity.ClientCommodity;
import com.thinkingFruit.client.mapper.AgentDao;
import com.thinkingFruit.client.mapper.ClientCommodityDao;
import com.thinkingFruit.client.service.ClientCommodityService;
/**
 * @author zhangzesen
 *
 * @date 2018年11月30日
 *
 * @package com.thinkingFruit.client.service.impl
 *
 * @description 商品
 */
@Service
public class ClientCommodityServiceImpl implements ClientCommodityService {
	
	@Autowired
	ClientCommodityDao clientCommodityDao;
	
	@Autowired
	private AgentDao agentDao;
	
	/**
	 * 	查看所有商品
	 * @return 商品集合
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public List<ClientCommodity> ClientCommodityList() {
		List<ClientCommodity> clientCommodityList = clientCommodityDao.ClientCommodityList();
		return clientCommodityList;
	}
	
	/**
	 * 	查看商品详情
	 * @param request
	 * @param id 商品id
	 * @return 商品
	 */
	@Transactional(rollbackFor = Exception.class)
	@Override
	public ClientCommodity findCommodityById(HttpServletRequest request,Long id) {
		//通过商品id查询商品信息
		ClientCommodity findCommodityById = clientCommodityDao.findCommodityById(id);
		//通过商品id查询商品详情图
		List<String> findCommodityImagesById = clientCommodityDao.findCommodityImagesById(id);
		//将商品详情图set进商品
		findCommodityById.setDetailsImagePaths(findCommodityImagesById);
		//从session中获取代理id
		HttpSession session = request.getSession();
		System.out.println("agentId"+session.getAttribute("agentId"));
		return findCommodityById;
	}

	/**
	 * 返回商品图片集合
	 */
	@Override
	public List<ClientCommodity> fingImgList() {
		List<ClientCommodity> imgList=clientCommodityDao.findImgList();
		return imgList;
	}

	

}
