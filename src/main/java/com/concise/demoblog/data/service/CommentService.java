package com.concise.demoblog.data.service;

import java.util.List;

import com.concise.demoblog.data.entity.Comment;

public interface CommentService {
	
	/**
	 * 新增留言信息
	 * @param comment
	 * @return
	 */
	boolean add(Comment comment);
	
	/**
	 * 删除留言信息
	 * @param id
	 * @return
	 */
	boolean delete(Integer id);
	
	/**
	 * 更新留言信息
	 * @param comment
	 * @return
	 */
	boolean update(Comment comment);
	
	/**
	 * 取得指定文章的留言
	 * @param id
	 * @return
	 */
	List<Comment> getCommentsByArrticleId(Integer id);
	
}
