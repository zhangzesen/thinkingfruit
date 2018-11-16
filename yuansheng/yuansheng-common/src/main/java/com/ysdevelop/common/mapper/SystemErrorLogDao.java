package com.ysdevelop.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ysdevelop.common.entity.system.SystemErrorLog;
import com.ysdevelop.common.page.Pagination;



public interface SystemErrorLogDao {

	public Integer getCountByQuyer(SystemErrorLog systemErrorLog);

	public List<SystemErrorLog> paginationByQuery(@Param(value="systemErrorLog")SystemErrorLog systemErrorLog, @Param(value="pagination")Pagination<SystemErrorLog> pagination);

	public void deleteByIds(List<Integer> ids);

	public void addSystemErrorLog(SystemErrorLog systemErrorLog);

}
