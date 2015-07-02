package com.concise.service;

import com.concise.entity.Link;

import java.util.List;

/**
 * 友情链接业务操作接口
 * Created by 刘印龙 on 2015/5/5.
 */
public interface ILinkService {

    /**
     * 新增友情链接
     * @param link
     * @return
     */
    void add(Link link);

    /**
     * 删除友情链接
     * @param id
     * @return
     */
    void delete(Integer id);

    /**
     * 更新友情链接
     * @param link
     * @return
     */
    void update(Link link);

    /**
     * 取得随机友情链接
     * @param random
     * @return
     */
    List<Link> getLinksByRandom(Integer random);
}
