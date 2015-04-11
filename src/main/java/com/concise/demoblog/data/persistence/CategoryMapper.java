package com.concise.demoblog.data.persistence;

import java.util.List;

import com.concise.demoblog.data.entity.Category;

/**
 * 文章类别数据操作接口
 * @author 刘印龙
 */
public interface CategoryMapper {

	/**
	 * 添加新类别
	 * @param category
	 * @return
	 */
	int add(Category category);
	
	/**
	 * 删除文章
	 * @param id
	 * @return
	 */
	int delete(Integer id);
	
	/**
	 * 更新类别信息
	 * @param category
	 * @return
	 */
	int update(Category category);
	
	/**
	 * 通过ID 查询
	 * @param id
	 * @return
	 */
	Category getById(Integer id);
	
	/**
	 * 通过关键词查询
	 * @param keyword
	 * @return
	 */
	List<Category> getByKeyword(String keyword);
	
	/**
	 * 通过名称得到编号
	 * @param name
	 * @return
	 */
	int getIdByName(String name);
}
