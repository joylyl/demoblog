package com.concise.demoblog.data.service;

import java.util.List;

import com.concise.demoblog.data.entity.User;

public interface UserService {

	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	boolean add(User user);
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	boolean delete(Integer id);
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	boolean update(User user);
	
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
}
