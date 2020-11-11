package com.xs.micro.es.domain.controller.api.tenant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangqiupeng
 * @desc test mongo connection ssl
 * @date 2020年06月15日17:07:44
 */

@RestController
@RequestMapping(value = "/test")
public class TestController {
    private static final Logger LOG = LoggerFactory.getLogger(TestController.class);


    @RequestMapping(value = "/business", method = RequestMethod.POST)
    public String businessTest()  {
        LOG.info("redis value is {} ", "testEureka");
        return "success";
    }



}
