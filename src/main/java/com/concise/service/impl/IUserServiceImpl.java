package com.concise.service.impl;

import com.concise.dao.BaseDao;
import com.concise.entity.User;
import com.concise.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户业务操作接口
 * Created by 刘印龙 on 2015/5/5.
 */
@Service
@Transactional
public class IUserServiceImpl implements IUserService {
    @Autowired
    private BaseDao baseDao;

    public void add(User user) {
        baseDao.addEntity(user);
    }

    public void delete(Integer id) {
        baseDao.delEntity(baseDao.findInfoById(User.class ,id ));
    }

    public void update(User user) {
        baseDao.updateEntity(user);
    }

    public User getUserById(Integer id) {
        return baseDao.findInfoById(User.class , id);
    }

    public List<User> getUsers() {
        return baseDao.findAll(User.class);
    }

    public User getUserByName(String name) {
        List<User> users = baseDao.findByKeyWord(
                User.class ,
                new String[]{"name"} ,
                new String[]{name} ,
                false , true );
        if(users.size() > 0)
            return users.get(0);
        return null;
    }

}
