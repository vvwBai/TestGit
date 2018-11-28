package com.itmuch.cloud.study.service;

import com.itmuch.cloud.study.entity.User;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface UserService {

    @RequestMapping(method = RequestMethod.GET ,value = "/users/{id}")
    User getUser(@PathVariable("id")long id);

}
