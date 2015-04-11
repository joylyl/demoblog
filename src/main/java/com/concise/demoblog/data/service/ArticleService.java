package com.concise.demoblog.data.service;

import java.util.List;

import com.concise.demoblog.data.entity.Article;

public interface ArticleService {
	/**
	 * 添加新文章
	 * @param article
	 * @return
	 */
	boolean add(Article article);
	
	/**
	 * 通过ID删除文章
	 * @param id
	 * @return
	 */
	boolean delete(Integer id);
	
	/**
	 * 修改文章
	 * @param article
	 * @return
	 */
	boolean update(Article article);
	
	/**
	 * 通过编号查找文章
	 * @param id
	 * @return
	 */
	Article getArticleById(Integer id);
	
	/**
	 * 查找所有文章
	 * @return
	 */
	List<Article> getArticles();

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
}
