package com.stef.ssm.controller;


import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @NacosValue(value = "${test}",autoRefreshed = true)
    private String test;


    @GetMapping("/echo/{msg}")
    @ResponseBody
    public String echo(@PathVariable(value = "msg") String msg){
        if (StringUtils.isEmpty(msg)){
            msg = "hello world!";
        }
        return msg + " "+ test;
    }
}
