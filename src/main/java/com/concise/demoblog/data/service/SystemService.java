package com.concise.demoblog.data.service;

import com.concise.demoblog.data.entity.System;

public interface SystemService {

	/**
	 * 新增系统信息
	 * @param system
	 * @return
	 */
	boolean add(System system);
	
	/**
	 * 更新系统信息
	 * @param system
	 * @return
	 */
	boolean update(System system);
	
	/**
	 * 查询
	 * @return
	 */
	System getSystem();
}
