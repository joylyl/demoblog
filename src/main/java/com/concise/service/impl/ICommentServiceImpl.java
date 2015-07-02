package com.concise.service.impl;

import com.concise.dao.BaseDao;
import com.concise.entity.Comment;
import com.concise.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 刘印龙 on 2015/5/5.
 */
@Service
@Transactional
public class ICommentServiceImpl implements ICommentService {

    @Autowired
    private BaseDao baseDao;

    public void add(Comment comment) {
        baseDao.addEntity(comment);
    }

    public void delete(Integer id) {
        baseDao.delEntity(baseDao.findInfoById(Comment.class , id));
    }

    public void update(Comment comment) {
        baseDao.updateEntity(comment);
    }

    public List<Comment> getCommentsByArrticleId(Integer id) {
        return baseDao.findByKeyWord(Comment.class, new String[]{"articleId"} , new String[]{id.toString()} , false , false  );
    }
}
