package com.xs.micro.es.config.bean;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author  wqp
 * @desc  rest client
 */

@Configuration
public class ConfigClient  {

    @Bean
    public RestClient  initRestClient(){
        RestClient restClient  = RestClient.builder(new HttpHost("localhost",9200,"http"),
                new HttpHost("localhost",9201,"http"),
                new HttpHost("localhost",9202,"http")).build();
        return  restClient;
    }


}
