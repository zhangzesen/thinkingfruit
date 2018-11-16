package com.ysdevelop.shiro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.shiro.mapper.RegionDao;
import com.ysdevelop.shiro.service.RegionService;

@Service
public class RegionServiceImpl implements RegionService {

	@Autowired
	RegionDao regionDao;
	
	@Override
	public Long findProvinceIdByProvinceName(String provName) {
		return regionDao.findProvinceIdByProvinceName(provName);
	}

	@Override
	public Long findCityIdByCityName(String cityName) {
		return regionDao.findCityIdByCityName(cityName);
	}

}
