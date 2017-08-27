package com.micro.svc.demo.product.web.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cheney on 2017/8/27.
 */
@RestController
public class IndexController {

    private Logger logger = Logger.getLogger(getClass());

    @Value("${spring.aplication.name}")
    private String applicationName;

    @RequestMapping(value = "", method = {RequestMethod.GET, RequestMethod.POST})
    public Object index() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("spring.aplication.name", applicationName);
        jsonObject.put("random.num", RandomStringUtils.randomNumeric(8));
        jsonObject.put("random.string", RandomStringUtils.randomAlphabetic(8));
        logger.info("result: " + jsonObject.toJSONString());
        return jsonObject;
    }

    @RequestMapping(value = "call", method = {RequestMethod.GET, RequestMethod.POST})
    public String call(String msg) {
        String result = RandomStringUtils.randomAlphabetic(6);
        String message = String.format("this is %s. i get a message[%s] and gen a random string[%s].",
                this.applicationName, msg, result
        );
        logger.info(message);
        return result;
    }
}
