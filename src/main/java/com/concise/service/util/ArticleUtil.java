package com.concise.service.util;

import com.concise.dao.BaseDao;
import com.concise.entity.Article;
import com.concise.entity.Tag;
import com.concise.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 刘印龙 on 2015/5/5.
 */
@Component
public class ArticleUtil {

    @Autowired
    private BaseDao baseDao;

    /**
     * 设置Tag和Catagory
     * @param article
     */
    public void setTagAndCatagory(Article article){
        List<Tag> tagList = new ArrayList<Tag>();
        //设置tag
        String [] tags = article.getTags().split(",");
        //查询得到每一个tag
        for (String tag : tags) {
            tagList.add(baseDao.findInfoById(Tag.class ,Integer.parseInt(tag) ));
        }
        //将查询到的所有tag添加到文章对象
        article.setTagList(tagList);
        //设置category
        article.setCategory(baseDao.findInfoById(Category.class , article.getCateid()));
    }
}
