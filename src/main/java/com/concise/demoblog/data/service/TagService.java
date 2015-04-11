package com.concise.demoblog.data.service;

import java.util.List;

import com.concise.demoblog.data.entity.Tag;

public interface TagService {


	/**
	 * 添加标签
	 * @param tag
	 * @return
	 */
	boolean add(Tag tag);
	
	/**
	 * 删除标签
	 * @param id
	 * @return
	 */
	boolean delete(Integer id);
	
	/**
	 * 修改标签
	 * @param tag
	 * @return
	 */
	boolean update(Tag tag);
	
	/**
	 * 查询所有标签
	 * @return
	 */
	List<Tag> getTags();
	
	/**
	 * 通过ID 查询
	 * @param id
	 * @return
	 */
	Tag getById(Integer id);	
	
	/**
	 * 通过关键字查询
	 * @param keyword
	 * @return
	 */
	List<Tag> getTagsByKeyword(String keyword);
}
