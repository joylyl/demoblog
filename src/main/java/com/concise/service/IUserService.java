package com.concise.service;

import com.concise.entity.User;

import java.util.List;

/**
 * 用户业务操作接口
 * Created by 刘印龙 on 2015/5/5.
 */
public interface IUserService {

    /**
     * 新增用户
     * @param user
     * @return
     */
    void add(User user);

    /**
     * 删除用户
     * @param id
     * @return
     */
    void delete(Integer id);

    /**
     * 修改用户信息
     * @param user
     * @return
     */
    void update(User user);

    /**
     * 通过ID 查询
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 查询所有
     * @return
     */
    List<User> getUsers();

    /**
     * 通过用户名查询
     * @param name
     * @return
     */
    User getUserByName(String name);
}
