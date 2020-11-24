package com.xs.micro.es.domain.dao;

import com.xs.micro.es.domain.pojo.model.BlogInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author topwqp
 */
@Repository
public interface BlogDao extends ElasticsearchRepository<BlogInfo,String> {
    /**
     * 使用jpa语法
     * @param str
     */
    void  queryAllByContent(String str);
}
