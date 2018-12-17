package com.itmuch.cloud.study.user.fallback;

import com.itmuch.cloud.study.user.entity.User;
import com.itmuch.cloud.study.user.service.UserFeignClient;
import org.springframework.stereotype.Component;

/***
 *  回退类FeignClientFalBack需实现Feign Client接口
 *  FeignClientFallback 也可以是public class,没有区别
 */
@Component
public class FeignClientFallBack implements UserFeignClient{


    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(-1L);
        user.setUsername("默认用户");

        return user;
    }
}
