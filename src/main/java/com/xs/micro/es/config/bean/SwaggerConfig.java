package com.xs.micro.es.config.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


/**
 * @Description swagger配置
 * @Author Wang QiuPeng
 * @date 2020年05月14日15:50:20
 **/
@Configuration
public class SwaggerConfig {

    /**
     * swagger2 配置
     * @return
     * @author Wang QiuPeng
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select().apis(RequestHandlerSelectors.basePackage("com.xs.micro.up.domain.controller"))
                // 本地、开发、测试环境扫描真正的Controller包
                .paths(PathSelectors.any()).build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("Saas-business微服务").description("saas-business微服务开发").termsOfServiceUrl("http://git.xs.jf/xs-overseas-loan-saas/saas-business.git")
                .contact(new Contact("xiangshang360.cn", "http://www.xiangshang360.cn", "wangqiupeng@xiangshang360.com")).version("1.0").build();
    }
}
