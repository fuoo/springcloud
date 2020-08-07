package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.apache.commons.lang3.ThreadUtils;
import org.apache.tomcat.jni.Time;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@RestController
public class FlowLimitController {
    private static int i = -1;
    @GetMapping("/testA")
    public String testA() {
        i++;
        if (i <= 3) {
            int k = 10/0;
        }
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {

        return "------testB";
    }
    @GetMapping("/testC")
    @SentinelResource(value = "testC",blockHandler = "test")
    public String testc(String p1, String p2) {
        return "p1: " + p1 + ",p2: " + p2;
    }

    public String test(String p1, String p2, BlockException e) {
        return "123";
    }

}



