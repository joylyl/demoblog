package com.concise.service;

import com.concise.entity.Article;

import java.util.List;

/**
 * 文章业务操作接口
 * Created by 刘印龙 on 2015/5/5.
 */
public interface IArticleService {

    /**
     * 添加新文章
     * @param article
     * @return
     */
    void add(Article article);

    /**
     * 通过ID删除文章
     * @param id
     * @return
     */
    void delete(Integer id);

    /**
     * 修改文章
     * @param article
     * @return
     */
    void update(Article article);

    /**
     * 通过编号查找文章
     * @param id
     * @return
     */
    Article getArticleById(Integer id);

    /**
     * 分页查找所有文章
     * @return
     */
    List<Article> getArticles(int offset , int length , boolean type);

    /**
     * 按条件查询
     * @return
     */
    List<Article> getArticlesBykeyword(String keyword);

    /**
     * 通过静态地址查询文章
     * @param staticURL
     * @return
     */
    Article getArticleByStaticURL(String staticURL);

    /**
     * 通过Category编号查询
     * @param id
     * @return
     */
    List<Article> getArticlesByCategoryId(Integer id);

    /**
     * 通过tag查找
     * @param tagName
     * @return
     */
    List<Article> getByTag(String tagName);

    /**
     * 得到阅读量最大的前10条
     * @return
     */
    List<Article> getTop10MaxByView();

    /**
     * 查询得到最新或最旧文章
     * @param type
     * @return
     */
    List<Article> getTop10OrderByDate(boolean type , Integer limit);

    /**
     * 将文章访问回收站
     * @param id
     */
    void trashArticle(Integer id);
}
