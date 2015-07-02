package com.concise.service.impl;

import com.concise.dao.BaseDao;
import com.concise.entity.Category;
import com.concise.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 刘印龙 on 2015/5/5.
 */
@Service
@Transactional
public class ICategoryServiceImpl implements ICategoryService{

    @Autowired
    private BaseDao baseDao;

    public void add(Category category) {
        baseDao.addEntity(category);
    }

    public void delete(Integer id) {
        baseDao.delEntity(baseDao.findInfoById(Category.class,id));
    }

    public void update(Category category) {
        baseDao.updateEntity(category);
    }

    public Category getById(Integer id) {
        return baseDao.findInfoById(Category.class,id);
    }

    public List<Category> getByKeyword(String keyword) {
        List<Category> categories = baseDao.findByKeyWord(Category.class , new String[]{"title"} , new String[]{keyword} , false ,true);
        for (Category category : categories){
            category.setParent(baseDao.findInfoById(Category.class , category.getParentId()));
        }
        return categories;
    }

    public Category getName(String name) {
        List<Category> categories =baseDao.findByKeyWord(Category.class , new String[]{"alias"} , new String[]{name} , false , true );
        return categories.size() > 0 ? categories.get(0) : null;
    }
}
