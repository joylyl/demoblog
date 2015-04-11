package com.concise.demoblog.data.service;

import java.util.List;

import com.concise.demoblog.data.entity.Link;

public interface LinkService {

	/**
	 * 新增友情链接
	 * @param link
	 * @return
	 */
	boolean add(Link link);
	
	/**
	 * 删除友情链接
	 * @param id
	 * @return
	 */
	boolean delete(Integer id);
	
	/**
	 * 更新友情链接
	 * @param link
	 * @return
	 */
	boolean update(Link link);
	
	/**
	 * 取得随机友情链接
	 * @param random
	 * @return
	 */
	List<Link> getLinksByRandom(Integer random);
}
