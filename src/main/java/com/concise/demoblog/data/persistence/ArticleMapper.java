package com.concise.demoblog.data.persistence;

import java.util.List;

import com.concise.demoblog.data.entity.Article;

/**
 * 文章数据操作接口
 * @author 刘印龙
 */
public interface ArticleMapper {

	/**
	 * 添加新文章
	 * @param article
	 * @return
	 */
	int add(Article article);
	
	/**
	 * 通过ID删除文章
	 * @param id
	 * @return
	 */
	int delete(Integer id);
	
	/**
	 * 修改文章
	 * @param article
	 * @return
	 */
	int update(Article article);
	
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
