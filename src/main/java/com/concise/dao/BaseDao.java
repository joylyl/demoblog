package com.concise.dao;

/**
 * 通用数据操作接口
 * Created by 刘印龙 on 2015/5/4.
 */
import java.util.List;

public interface BaseDao {

    /**
     * 查询所有
     */
    public <T> List<T> findAll(Class<T> clazz);

    /**
     * 添加
     */
    public <T> void addEntity(T entity);

    /**
     * 删除
     */
    public <T> void delEntity(T entity);

    /**
     * 修改
     */
    public <T> void updateEntity(T entity);

    /**
     * 通过关键字(模糊/精确)查找
     * @param clazz 查找的类
     * @param filedName 要查找的字段数组
     * @param keyword 要查找的字段数组对应的值
     * @param type 是否是模糊查找 false:精确查找  true:模糊查找
     * @param orderby 排序方式 true:正序   false:倒序
     * @param <T>
     * @return
     */
    public <T> List<T> findByKeyWord(Class<T> clazz , String[] filedName , String[] keyword , boolean type , boolean orderby);

    /**
     * 通过编号查询
    */
    public <T> T findInfoById(Class<T> clazz , Integer id);

    /**
     * 分页通用方法
     * @param clazz 查找的类
     * @param offset  起始记录下标
     * @param lengh  读取记录数
     * @return
     */
    public <T> List<T> findByPage(final Class<T> clazz, final int offset, final int lengh , boolean type);

    /**
     * 查询得到数量.
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> Integer getCount(Class<T> clazz);

    /**
     * 查询指定列的最大和最小
     * @param clazz
     * @param fileName 字段名
     * @param type true:max  false:min
     * @param <T>
     * @return
     */
    public <T> List<T> getMaxOrMin(Class<T> clazz , String fileName , boolean type);

    /**
     * 查询指定数量的排序内容
     * @param clazz
     * @param type true:desc  , false:asc
     * @param limit 查询数量
     * @param <T>
     * @return
     */
    public <T> List<T> getOrderBy(Class<T> clazz , boolean type , String fileName,  Integer limit );

}
