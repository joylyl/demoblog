package com.concise.demoblog.data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concise.demoblog.data.entity.System;
import com.concise.demoblog.data.persistence.SystemMapper;
import com.concise.demoblog.data.service.SystemService;

@Service
public class SystemServiceImpl implements SystemService{

	@Autowired
	private SystemMapper systemMapper;
	
	public boolean add(System system) {
		return systemMapper.add(system) == 0 ? false : true ;
	}

	public boolean update(System system) {
		return systemMapper.update(system) == 0 ? false : true ;
	}

	public System getSystem() {
		return systemMapper.getSystem();
	}

}
