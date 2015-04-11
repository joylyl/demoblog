package com.concise.demoblog.data.persistence;

import java.util.List;

import com.concise.demoblog.data.entity.Link;

/**
 * 友情链接数据操作接口
 * @author 刘印龙
 */
public interface LinkMapper {

	/**
	 * 新增友情链接
	 * @param link
	 * @return
	 */
	int add(Link link);
	
	/**
	 * 删除友情链接
	 * @param id
	 * @return
	 */
	int delete(Integer id);
	
	/**
	 * 更新友情链接
	 * @param link
	 * @return
	 */
	int update(Link link);
	
	/**
	 * 取得随机友情链接
	 * @param random
	 * @return
	 */
	List<Link> getLinksByRandom(Integer random);
}
