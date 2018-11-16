package com.ysdevelop.shiro.service;

public interface RegionService {

	//根据省名寻找表中的省id
	Long findProvinceIdByProvinceName(String provName);

	//根据市名寻找表中的市id
	Long findCityIdByCityName(String cityName);

}
