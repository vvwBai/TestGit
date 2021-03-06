package com.itmuch.cloud.study.user.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.exception.HystrixTimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.itmuch.cloud.study.user.entity.User;

import java.net.ConnectException;
import java.util.concurrent.TimeoutException;

@RestController
public class MovieController {
  private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private LoadBalancerClient loadBalancerClient;

  @HystrixCommand(fallbackMethod = "findByIdFallback", ignoreExceptions = {IllegalArgumentException.class, HystrixTimeoutException.class, ConnectException.class, TimeoutException.class})
  @GetMapping("/user/{id}")
  public User findById(@PathVariable Long id) throws myException {

//    if(id != 3){
//      throw new myException();
//    }

    return this.restTemplate.getForObject("http://microservice-provider-user/" + id, User.class);
  }

  public User findByIdFallback(Long id,  Throwable throwable){
    LOGGER.info("进入回退方法： 异常："+throwable);
    User user = new User();
    user.setId(-1L);
    user.setName("默认用户");
    return user;
  }

  @GetMapping("/log-user-instance")
  public void logUserInstance() {
    ServiceInstance serviceInstance = this.loadBalancerClient.choose("microservice-provider-user");
    // 打印当前选择的是哪个节点
    MovieController.LOGGER.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
  }

  class myException extends Exception{

  }


}
