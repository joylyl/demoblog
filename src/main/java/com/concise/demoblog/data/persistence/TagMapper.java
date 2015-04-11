package com.concise.demoblog.data.persistence;

import java.util.List;

import com.concise.demoblog.data.entity.Tag;

/**
 * 标签数据操作接口
 * @author 刘印龙
 */
public interface TagMapper {

	/**
	 * 添加标签
	 * @param tag
	 * @return
	 */
	int add(Tag tag);
	
	/**
	 * 删除标签
	 * @param id
	 * @return
	 */
	int delete(Integer id);
	
	/**
	 * 修改标签
	 * @param tag
	 * @return
	 */
	int update(Tag tag);
	
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
