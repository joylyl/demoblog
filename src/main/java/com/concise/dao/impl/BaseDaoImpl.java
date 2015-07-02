package com.concise.dao.impl;

import com.concise.dao.BaseDao;
import com.concise.entity.Article;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import java.sql.SQLException;
import java.util.List;

/**
 * 数据通用操作实现类
 * Created by 刘印龙 on 2015/5/4.
 */

@Component
public class BaseDaoImpl extends HibernateDaoSupport implements BaseDao{

    public <T> List<T> findAll(Class<T> clazz) {
        String sql = "from " + clazz.getName();
        return (List<T>)getHibernateTemplate().find(sql);
    }

    public <T> void addEntity(T entity) {
        getHibernateTemplate().save(entity);
    }

    public <T> void delEntity(T entity) {
        getHibernateTemplate().delete(entity);
    }

    public <T> void updateEntity(T entity) {
        getSession().clear();
//        entity = getHibernateTemplate().merge(entity);
        getHibernateTemplate().update(entity);
    }

    public <T> List<T> getMaxOrMin(Class<T> clazz, String fileName, boolean type) {
        String way = "desc";
        if(!type)
            way = "asc";

        String sql ="from " + clazz.getName() + " order by " + fileName + " " + way + " limit 10 ";
        return getHibernateTemplate().find(sql);
    }

    public <T> List<T> getOrderBy(Class<T> clazz, boolean type , String fileName, Integer limit) {
        String typeStr = "asc";
        if(type)
            typeStr = "desc";
        return getHibernateTemplate().find("from " + clazz.getName() + " order by " + fileName + " " + typeStr +" limit" + limit);
    }

    public <T> Integer getCount(final Class<T> clazz) {
        String sql ="select count(1) from "+clazz.getName();

        return ((Integer)getHibernateTemplate().iterate(sql).next()).intValue();

    }

    public <T> List<T> findByKeyWord(Class<T> clazz , String[] filedName , String[] keyword , boolean type , boolean orderby) {
        StringBuffer sql = new StringBuffer("from " +clazz.getName() +"");
        if(filedName.length>0){//如果有参数
            for (int i = 0; i < filedName.length; i++) {
                if(keyword[i]!=null&&!keyword[i].equals("")){//如果查询条件的值为空
                    if(type){//模糊查询
                        if(i==0||sql.toString().indexOf("where")==-1)//如果是第一个或者整个sql语句中还没有where关键字出现
                            sql.append(" where "+filedName[i] +" like '%"+ keyword[i]+"%'");
                        else if(i==filedName.length-1)//如果是最后一个参数,那么就加and
                            sql.append(" and "+filedName[i] +" like '%"+ keyword[i]+"%'");
                        else
                            sql.append(" and "+filedName[i] +" like '%"+ keyword[i]+"%' and");
                    }else{
                        if(i==0||sql.toString().indexOf("where")==-1)
                            sql.append(" where "+filedName[i] +" = '"+ keyword[i]+"'");
                        else if(i==filedName.length-1)
                            sql.append(" and "+filedName[i] +" = '"+ keyword[i]+"'");
                        else
                            sql.append(" and "+filedName[i] +" = '"+ keyword[i]+"' and");
                    }
                }else
                    continue;
            }
        }
        if(orderby)
            sql.append(" order by id asc ");
        else
            sql.append(" order by id desc ");

        return (List<T>)getHibernateTemplate().find(sql.toString());
    }

    public <T> T findInfoById(Class<T> clazz , Integer id) {
        return getHibernateTemplate().get(clazz, id);
    }


    public <T> List<T>  findByPage(final Class<T> clazz, final int offset, final int lengh , boolean type) {
        final StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("from " + clazz.getName());
        if (clazz == Article.class){
            if (type){
                sqlBuilder.append(" order by id desc ");
                sqlBuilder.append(" where isrecover=0");
            }
        }
        try {
            List list = getHibernateTemplate().executeFind(new HibernateCallback() {

                public Object doInHibernate(Session session)
                        throws HibernateException, SQLException {
                    List list2 = session.createQuery(sqlBuilder.toString())
                            .setFirstResult(offset)
                            .setMaxResults(lengh)
                            .list();
                    return list2;
                }});
            return list;
        } catch (RuntimeException re) {
            throw re;
        }
    }
}
