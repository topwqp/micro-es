package com.xs.micro.es.domain.es.service;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.RequestLine;
import org.apache.http.util.EntityUtils;
import org.elasticsearch.client.*;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.sniff.Sniffer;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;

/**
 * @author wqp
 * @date 2020年11月12日14:24:32
 */
@Service
public class MeetElasticSearchService {

    private static final Logger LOG = LoggerFactory.getLogger(MeetElasticSearchService.class);

    @Autowired
    private  RestHighLevelClient  client;

    private RestClient restClient;



    @PostConstruct
    public void initEs(){
        restClient  = RestClient.builder(new HttpHost("localhost",9200,"http"),
                new HttpHost("localhost",9201,"http"),
                new HttpHost("localhost",9202,"http")).build();
        LOG.info("init Es  finished");
    }

    public void closeEs(){
        try {
            restClient.close();
        }catch (Exception e){
            LOG.error("close Es occur error ",e);
        }

    }

    /**
     * 如何构建es的服务请求
     * @return
     */
    public String executeRequest(){
        Request  request = new Request("GET","/");
        try {
            Response response = restClient.performRequest(request);
            return response.toString();
        }catch (Exception e){
            LOG.error("execute request occur error ",e);
        }

        return "Get Result failed";
    }

    public String buildRequestAsync(){
        Request request = new Request("GET","/");
        restClient.performRequestAsync(request, new ResponseListener() {
            @Override
            public void onSuccess(Response response) {

            }

            @Override
            public void onFailure(Exception exception) {

            }
        });
        try {
            restClient.close();
        }catch (Exception e){
            LOG.error("buildRequestAsync occur error",e);
        }
        return "Get Result Failed";
    }

    public void parseElasticSearchResponse() {
        try {
            Response response = restClient.performRequest(new Request("GET","/"));
            //已执行请求的信息
            RequestLine requestLine = response.getRequestLine();
            LOG.info("request line is {} ",requestLine);
            //HOST返回信息
            HttpHost host = response.getHost();
            LOG.info("host is {}",host);
            //响应状态行，从中可以解析状态代码
            int statusCode = response.getStatusLine().getStatusCode();
            LOG.info("statusCode is {}",statusCode);
            //响应头，也可以通过getheader(String)按名字获取
            Header[] headers = response.getHeaders();
            String responseBody = EntityUtils.toString(response.getEntity());
            LOG.info("parse elastic  response ,responseBody is :" + responseBody);
        }catch (Exception e){
            LOG.error("parse ElasticSearch Response fail",e);
        }
    }

    /**
     * 配置嗅探器
     */
    public void setSniffer(){
        RestClient  restClient  = RestClient.builder(new HttpHost("localhost",9200,"http"),
                new HttpHost("localhost",9201,"http"),
                new HttpHost("localhost",9202,"http")).build();
        Sniffer sniffer = Sniffer.builder(restClient).setSniffIntervalMillis(60000).build();
        //嗅探器   默认每5min 更新一次节点，可以通过setSniffIntervalMills自定义间隔
        try {
            sniffer.close();
            restClient.close();
        }catch (Exception e){
            LOG.error("set sniffer occur fail ",3);
        }
    }



    public boolean createUserIndex(String index) throws IOException {
        CreateIndexRequest createIndexRequest = new CreateIndexRequest(index);
        createIndexRequest.settings(Settings.builder()
                .put("index.number_of_shards", 1)
                .put("index.number_of_replicas", 0)
        );
        createIndexRequest.mapping("{\n" +
                "  \"properties\": {\n" +
                "    \"city\": {\n" +
                "      \"type\": \"keyword\"\n" +
                "    },\n" +
                "    \"sex\": {\n" +
                "      \"type\": \"keyword\"\n" +
                "    },\n" +
                "    \"name\": {\n" +
                "      \"type\": \"keyword\"\n" +
                "    },\n" +
                "    \"id\": {\n" +
                "      \"type\": \"keyword\"\n" +
                "    },\n" +
                "    \"age\": {\n" +
                "      \"type\": \"integer\"\n" +
                "    }\n" +
                "  }\n" +
                "}", XContentType.JSON);
        CreateIndexResponse createIndexResponse = client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
        return createIndexResponse.isAcknowledged();
    }
}
