package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {

    @Override
    public String paymentInfo_OK(Integer id) {
        return "超时/异常处理";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "超时/异常处理";
    }
}
