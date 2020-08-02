package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.entities.Payment;

public interface PaymentService {

    int create(Payment payment); //写

    Payment getPaymentById(Long id);  //读取
}


