package com.ysdevelop.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.common.entity.system.SystemErrorLog;
import com.ysdevelop.common.mapper.SystemErrorLogDao;
import com.ysdevelop.common.page.Pagination;
import com.ysdevelop.common.service.SystemErrorLogService;


@Service("systemErrorLogService")
public class SystemErrorLogServiceImpl implements SystemErrorLogService {
	
	@Autowired(required=false)
	private SystemErrorLogDao systemErrorLogDao;
	
	@Override
	public Pagination<SystemErrorLog> paginationSystemErrorLog(SystemErrorLog systemErrorLog,
			Pagination<SystemErrorLog> pagination) {
		//获取总条数
		Integer count = systemErrorLogDao.getCountByQuyer(systemErrorLog);
		//获取分页的结果集
		List<SystemErrorLog> systemErrorLogs=systemErrorLogDao.paginationByQuery(systemErrorLog,pagination);
		pagination.setTotalItemsCount(count);
		pagination.setItems(systemErrorLogs);
		return pagination;
	}

	@Override
	public void deleteByIds(List<Integer> ids) {
		systemErrorLogDao.deleteByIds(ids);
	}

	@Override
	public void addSystemErrorLog(SystemErrorLog systemErrorLog) {
		systemErrorLogDao.addSystemErrorLog(systemErrorLog);
	}

}
