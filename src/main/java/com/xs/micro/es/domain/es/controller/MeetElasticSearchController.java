package com.xs.micro.es.domain.es.controller;

import com.xs.micro.es.domain.es.service.MeetElasticSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wqp
 * @date 2020年11月12日14:20:54
 */
@RestController
@RequestMapping("/springboot/es")
public class MeetElasticSearchController {

    @Autowired
    private MeetElasticSearchService meetElasticSearchService;

    @RequestMapping("/init")
    public String initElasticSearch(){
        meetElasticSearchService.initEs();
        return "init elasticSearch over";
    }

    @RequestMapping("/buildRequest")
    public String executeRequestForElasticSearch(){
        return meetElasticSearchService.executeRequest();
    }

    @RequestMapping("/parseEsResponse")
    public String parseElasticSearchResponse(){
         meetElasticSearchService.parseElasticSearchResponse();
        return "Parse ElasticSearch Response is over";
    }
}
