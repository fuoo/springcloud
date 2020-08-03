package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.entities.Payment;
import com.atguigu.springcloud.alibaba.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public int create(Payment payment){
        return 1;
    }

    @Override
    public Payment getPaymentById( Long id){
        return new Payment( 1L,"123");
    }
}


