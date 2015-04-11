package com.concise.demoblog.data.persistence;

import java.util.List;

import com.concise.demoblog.data.entity.Comment;

/**
 * 留言数据操作接口
 * @author 刘印龙
 */
public interface CommentMapper {

	/**
	 * 新增留言信息
	 * @param comment
	 * @return
	 */
	int add(Comment comment);
	
	/**
	 * 删除留言信息
	 * @param id
	 * @return
	 */
	int delete(Integer id);
	
	/**
	 * 更新留言信息
	 * @param comment
	 * @return
	 */
	int update(Comment comment);
	
	/**
	 * 取得指定文章的留言
	 * @param id
	 * @return
	 */
	List<Comment> getCommentsByArrticleId(Integer id);
	
}
