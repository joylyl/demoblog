package com.concise.demoblog.data.persistence;

import java.util.List;

import com.concise.demoblog.data.entity.User;

/**
 * 用户信息操作接口
 * @author 刘印龙
 */
public interface UserMapper {

	/**
	 * 新增用户
	 * @param user
	 * @return
	 */
	int add(User user);
	
	/**
	 * 删除用户
	 * @param id
	 * @return
	 */
	int delete(Integer id);
	
	/**
	 * 修改用户信息
	 * @param user
	 * @return
	 */
	int update(User user);
	
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
