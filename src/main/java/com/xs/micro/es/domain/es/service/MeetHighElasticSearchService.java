package com.xs.micro.es.domain.es.service;

import javafx.scene.control.IndexRange;
import org.elasticsearch.action.index.IndexRequest;
import org.springframework.stereotype.Service;

/**
 * @author wqp
 * @date 2020年11月12日16:50:55
 */
@Service
public class MeetHighElasticSearchService {

    /**
     * 基于string 构建IndexRequest
     * @param indexName
     * @param document
     */
    public void buildIndexRequestWithString(String indexName,String document){
        //索引名称
        IndexRequest request = new IndexRequest(indexName);
        //文档ID
        request.id(document);

    }
}
