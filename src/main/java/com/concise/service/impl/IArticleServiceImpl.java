package com.concise.service.impl;

import com.concise.dao.BaseDao;
import com.concise.entity.Article;
import com.concise.entity.Tag;
import com.concise.service.IArticleService;
import com.concise.service.ITagService;
import com.concise.service.util.ArticleUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 刘印龙 on 2015/5/5.
 */
@Service
@Transactional
public class IArticleServiceImpl implements IArticleService {

    @Autowired
    private BaseDao baseDao;
    @Autowired
    private ITagService iTagService;

    public List<Article> getTop10OrderByDate(boolean type , Integer limit) {
        return baseDao.getOrderBy(Article.class , type , "createTime" ,limit);
    }

    @Autowired
    private ArticleUtil articleUtil;

    public void add(Article article) {
        baseDao.addEntity(article);
    }

    public void delete(Integer id) {
        Article article = new Article();
        article.setId(id);
        baseDao.delEntity(article);
    }

    public void update(Article article) {
        Article temp = getArticleById(article.getId());
        article.setCreatetime(temp.getCreatetime());
        if(article.getView() != temp.getView()+1)
            article.setView(temp.getView());
        article.setCommentNum(temp.getCommentNum());
        baseDao.updateEntity(article);
    }

    public Article getArticleById(Integer id) {
        Article article = baseDao.findInfoById(Article.class,id);
        List<Tag> tags = new ArrayList<Tag>();
        String[] tagArr = article.getTags().split(",");
        for (int i = 0 ; i < tagArr.length ; i++){
            tags.add(iTagService.getById(Integer.parseInt(tagArr[i])));
        }
        article.setTagList(tags);
        return article;
    }

    public void trashArticle(Integer id) {
        Article article = baseDao.findInfoById(Article.class, id);
        article.setIsrecover(1);
        baseDao.updateEntity(article);
    }

    public List<Article> getArticles(int offset , int length , boolean type) {
        if(offset > 0 && length > 0)
            offset = offset*length;
        List<Article> articles = baseDao.findByPage(Article.class , offset , length ,type) ;
        for (Article article : articles) {
            articleUtil.setTagAndCatagory(article);
        }
        return articles;
    }

    public List<Article> getArticlesBykeyword(String keyword) {
        List<Article> articles =baseDao.findByKeyWord(Article.class,new String[]{"title","content"},new String[]{keyword,keyword} , true , false);
        for (Article article : articles) {
            articleUtil.setTagAndCatagory(article);
        }
        return articles;
    }

    public Article getArticleByStaticURL(String staticURL) {
        List<Article> articles = baseDao.findByKeyWord(Article.class, new String[]{"staticurl"}, new String[]{staticURL} , false , true );
        return articles.size() > 0 ? articles.get(0) : null;
    }

    public List<Article> getArticlesByCategoryId(Integer id) {
        List<Article> articles = baseDao.findByKeyWord(Article.class , new String[]{"cateid"} , new String[]{id.toString()} , false , false );
        for (Article article : articles) {
            articleUtil.setTagAndCatagory(article);
        }
        return articles;
    }

    public List<Article> getByTag(String alias) {
        List<Article> articles =
                baseDao.findByKeyWord(
                        Article.class ,
                        new String[]{"tags"} ,
                        new String[]{baseDao.findByKeyWord(
                                Tag.class ,
                                new String[]{"alias"} ,
                                new String[]{alias} ,
                                false , true
                        ).get(0).getId()+""} ,
                        true , false );
        for (Article article : articles) {
            articleUtil.setTagAndCatagory(article);
        }
        return articles;
    }

    public List<Article> getTop10MaxByView() {
       return baseDao.getMaxOrMin(Article.class , "view", true);
    }
}
