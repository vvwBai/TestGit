package com.itmuch.cloud.study.user.service;

import com.itmuch.cloud.study.user.config.FeignLogConfiguration;
import com.itmuch.cloud.study.user.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "microservice-provider-user")
public interface UserFeignClient {

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);

}
