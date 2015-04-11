package com.concise.demoblog.data.persistence;

import com.concise.demoblog.data.entity.System;

/**
 * 系统信息数据操作接口
 * @author 刘印龙
 */
public interface SystemMapper {

	/**
	 * 新增系统信息
	 * @param system
	 * @return
	 */
	int add(System system);
	
	/**
	 * 更新系统信息
	 * @param system
	 * @return
	 */
	int update(System system);
	
	/**
	 * 查询
	 * @return
	 */
	System getSystem();
}
