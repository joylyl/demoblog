package com.concise.service.impl;

import com.concise.dao.BaseDao;
import com.concise.entity.Tag;
import com.concise.service.ITagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 刘印龙 on 2015/5/5.
 */
@Service
@Transactional
public class ITagServiceImpl implements ITagService {

    @Autowired
    private BaseDao baseDao;

    public void add(Tag tag) {
        baseDao.addEntity(tag);
    }

    public void delete(Integer id) {
        baseDao.delEntity(baseDao.findInfoById(Tag.class , id));
    }

    public void update(Tag tag) {
        baseDao.updateEntity(tag);
    }

    public List<Tag> getTags() {
        return baseDao.findAll(Tag.class);
    }

    public Tag getById(Integer id) {
        return baseDao.findInfoById(Tag.class , id );
    }

    public List<Tag> getTagsByKeyword(String name ,String keyword) {
        return baseDao.findByKeyWord(Tag.class , new String[]{name} , new String[]{keyword} , false , true );
    }
}
