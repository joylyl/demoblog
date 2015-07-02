package com.concise.service;

import com.concise.entity.Comment;

import java.util.List;

/**
 *评论留言业务操作接口
 * Created by 刘印龙 on 2015/5/5.
 */
public interface ICommentService {

    /**
     * 新增留言信息
     * @param comment
     * @return
     */
    void add(Comment comment);

    /**
     * 删除留言信息
     * @param id
     * @return
     */
    void delete(Integer id);

    /**
     * 更新留言信息
     * @param comment
     * @return
     */
    void update(Comment comment);

    /**
     * 取得指定文章的留言
     * @param id
     * @return
     */
    List<Comment> getCommentsByArrticleId(Integer id);
}
