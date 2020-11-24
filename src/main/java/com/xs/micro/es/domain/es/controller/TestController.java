package com.xs.micro.es.domain.es.controller;

import com.xs.micro.es.domain.dao.BlogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author topwqp
 */
@RestController
@RequestMapping("/es/test")
public class TestController {
    @Autowired
    private BlogDao blogDao;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchTemplate;
}
