package com.concise.demoblog.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concise.demoblog.data.entity.User;
import com.concise.demoblog.data.persistence.UserMapper;
import com.concise.demoblog.data.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;
	
	public boolean add(User user) {
		return userMapper.add(user) == 0 ? false : true ;
	}

	public boolean delete(Integer id) {
		return userMapper.delete(id) == 0 ? false : true ;
	}

	public boolean update(User user) {
		return userMapper.update(user) == 0 ? false : true ;
	}

	public User getUserById(Integer id) {
		return userMapper.getUserById(id);
	}

	public List<User> getUsers() {
		return userMapper.getUsers();
	}

}
