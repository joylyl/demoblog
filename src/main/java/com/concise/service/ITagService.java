package com.concise.service;

import com.concise.entity.Tag;

import java.util.List;

/**
 * 标签操作业务接口
 * Created by 刘印龙 on 2015/5/5.
 */
public interface ITagService {

    /**
     * 添加标签
     * @param tag
     * @return
     */
    void add(Tag tag);

    /**
     * 删除标签
     * @param id
     * @return
     */
    void delete(Integer id);

    /**
     * 修改标签
     * @param tag
     * @return
     */
    void update(Tag tag);

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
    List<Tag> getTagsByKeyword(String name , String keyword);
}
