package com.concise.demoblog.data.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.concise.demoblog.data.entity.Article;
import com.concise.demoblog.data.entity.Tag;
import com.concise.demoblog.data.persistence.ArticleMapper;
import com.concise.demoblog.data.persistence.CategoryMapper;
import com.concise.demoblog.data.persistence.TagMapper;
import com.concise.demoblog.data.service.ArticleService;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleMapper articleMapper;
	@Autowired
	private TagMapper tagMapper;
	@Autowired
	private CategoryMapper categoryMapper;
	
	public boolean add(Article article) {
		article.setCreatetime(null);
		//设置文章不在回收站
		article.setIsrecover(1);
		return articleMapper.add(article) == 0 ? false : true  ;
	}

	public boolean delete(Integer id) {
		return articleMapper.delete(id) == 0 ? false : true ;
	}

	public boolean update(Article article) {
		//得到一个完整的article对象
		Article articleSource = articleMapper.getArticleById(article.getId());
		
		articleSource.setContent(article.getContent());
		articleSource.setContentSource(article.getContentSource());
		articleSource.setDescription(article.getDescription());
		articleSource.setIsrecover(article.getIsrecover());
		articleSource.setStaticurl(article.getStaticurl());
		articleSource.setTags(article.getTags());
		articleSource.setTitle(article.getTitle());
		articleSource.setCateid(article.getCateid());
		
		return articleMapper.update(articleSource) == 0 ? false : true ;
	}
	
	public Article getArticleById(Integer id) {
		Article article = articleMapper.getArticleById(id);
		setTagAndCatagory(article);
		return article;
	}

	public List<Article> getArticles() {
		List<Article> articles = articleMapper.getArticles(); 
		for (Article article : articles) {
			setTagAndCatagory(article);
		}
		return articles;
	}
	
	/**
	 * 设置Tag和Catagory
	 * @param article
	 */
	private void setTagAndCatagory(Article article){
		List<Tag> tagList = new ArrayList<Tag>();
		//设置tag
		String [] tags = article.getTags().split(",");
		//查询得到每一个tag
		for (String tag : tags) {
			tagList.add(tagMapper.getById(Integer.parseInt(tag)));
		}
		//将查询到的所有tag添加到文章对象
		article.setTagList(tagList);
		//设置category
		article.setCategory(categoryMapper.getById(article.getCateid()));
	}

	public List<Article> getArticlesBykeyword(String keyword) {
		List<Article> articles = articleMapper.getArticlesBykeyword(keyword);
		for (Article article : articles) {
			setTagAndCatagory(article);
		}
		return articles;
	}

	public Article getArticleByStaticURL(String staticURL) {
		Article article = articleMapper.getArticleByStaticURL(staticURL);
		setTagAndCatagory(article);
		return article;
	}

	public List<Article> getArticlesByCategoryId(Integer id) {
		List<Article> articles = articleMapper.getArticlesByCategoryId(id);
		for (Article article : articles) {
			setTagAndCatagory(article);
		}
		return articles;
	}

}
