package com.concise.service;

import com.concise.entity.System;

/**
 * 系统信息业务操作接口
 * Created by 刘印龙 on 2015/5/5.
 */
public interface ISystemService {

    /**
     * 新增系统信息
     * @param system
     * @return
     */
    void add(System system);

    /**
     * 更新系统信息
     * @param system
     * @return
     */
    void update(System system);

    /**
     * 查询
     * @return
     */
    System getSystem();
}
