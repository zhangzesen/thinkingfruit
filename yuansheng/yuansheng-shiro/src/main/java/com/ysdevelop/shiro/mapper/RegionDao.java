package com.ysdevelop.shiro.mapper;

import org.apache.ibatis.annotations.Param;

public interface RegionDao {

	//根据省名寻找表中的省id
	Long findProvinceIdByProvinceName(@Param("provName")String provName);

	//根据市名寻找表中的市id
	Long findCityIdByCityName(@Param("cityName")String cityName);

}
