package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Resource
    DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String port;


    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result = paymentService.create(payment);
        log.info("插入结果：" + payment);
        if (result>0){  //成功
            return new CommonResult(200,"插入数据库成功。端口：" + port,result);
        }else {
            return new CommonResult(444,"插入数据库失败。端口：" + port, null);
        }
    }
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("*****查询结果："+payment);
        if (payment!=null){  //说明有数据，能查询成功
            return new CommonResult(200,"查询成功。端口：" + port,payment);
        }else {
            return new CommonResult(444,"没有对应记录，查询ID："+id + "端口：" + port,null);
        }
    }

    @GetMapping(value = "/payment/get/discovery")
    public CommonResult getDiscoveryClient() {
        CommonResult<String> commonResult = new CommonResult();
        commonResult.setCode(200);
        commonResult.setMessage("获取discoveryClient");
        List<String> services = discoveryClient.getServices();
        String s = "";
        for (String se : services) {
            s = se + ",";
            List<ServiceInstance> serviceInstances = discoveryClient.getInstances(se);
            for (ServiceInstance instance: serviceInstances) {
                log.info(instance.getPort() + "______" + instance.getHost() );
            }
        }
        commonResult.setData(s);
        return commonResult;
    }

    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try { TimeUnit.SECONDS.sleep(3); }catch (Exception e) {e.printStackTrace();}
        return port;
    }

}





