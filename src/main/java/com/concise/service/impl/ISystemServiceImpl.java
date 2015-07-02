package com.concise.service.impl;

import com.concise.dao.BaseDao;
import com.concise.entity.System;
import com.concise.service.ISystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 刘印龙 on 2015/5/5.
 */
@Service
@Transactional
public class ISystemServiceImpl implements ISystemService{

    @Autowired
    private BaseDao baseDao;

    public void add(System system) {
        baseDao.addEntity(system);
    }

    public void update(System system) {
        baseDao.updateEntity(system);
    }

    public System getSystem() {
        return baseDao.findAll(System.class).get(0);
    }
}
