package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;

public interface PaymentService {

    int create(Payment payment); //写

    Payment getPaymentById(Long id);  //读取
}


