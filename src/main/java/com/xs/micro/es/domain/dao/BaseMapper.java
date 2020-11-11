package com.xs.micro.es.domain.dao;

/**
 * @Description dao层基准接口
 * @Author Wang QiuPeng
 * 2019年05月13日14:15:09
 **/
public interface BaseMapper<T> {
    /**
     * 获取单条数据
     *
     * @param id
     * @return
     */
    T getById(Integer id);

}
