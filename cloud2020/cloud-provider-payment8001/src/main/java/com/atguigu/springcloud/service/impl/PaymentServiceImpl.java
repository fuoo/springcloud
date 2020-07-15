package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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


