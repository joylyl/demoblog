package com.concise.service;
import com.concise.entity.Category;

import java.util.List;

/**
 * 文章类别业务操作接口
 * Created by 刘印龙 on 2015/5/5.
 */
public interface ICategoryService {

    /**
     * 添加新类别
     * @param category
     * @return
     */
    void add(Category category);

    /**
     * 删除文章
     * @param id
     * @return
     */
    void delete(Integer id);

    /**
     * 更新类别信息
     * @param category
     * @return
     */
    void update(Category category);

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
    Category getName(String name);
}
