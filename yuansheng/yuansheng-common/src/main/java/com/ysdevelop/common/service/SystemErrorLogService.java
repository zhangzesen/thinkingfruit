package com.ysdevelop.common.service;

import java.util.List;

import com.ysdevelop.common.entity.system.SystemErrorLog;
import com.ysdevelop.common.page.Pagination;



public interface SystemErrorLogService {
	
	public Pagination<SystemErrorLog> paginationSystemErrorLog(SystemErrorLog systemErrorLog,
			Pagination<SystemErrorLog> pagination);

	public void deleteByIds(List<Integer> ids);

	public void addSystemErrorLog(SystemErrorLog systemErrorLog);
	
}
