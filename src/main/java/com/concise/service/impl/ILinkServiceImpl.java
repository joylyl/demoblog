package com.concise.service.impl;

import com.concise.dao.BaseDao;
import com.concise.entity.Link;
import com.concise.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 刘印龙 on 2015/5/5.
 */
@Service
@Transactional
public class ILinkServiceImpl implements ILinkService {

    @Autowired
    private BaseDao baseDao;

    public void add(Link link) {
        baseDao.addEntity(link);
    }

    public void delete(Integer id) {
        baseDao.delEntity(baseDao.findInfoById(Link.class , id));
    }

    public void update(Link link) {
        baseDao.updateEntity(link);
    }

    public List<Link> getLinksByRandom(Integer random) {
        return baseDao.findByKeyWord(Link.class , new String[]{"random"}, new String[]{random.toString()} , false ,true  );
    }
}
