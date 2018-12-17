package com.itmuch.cloud.study.user.fallback;

import com.itmuch.cloud.study.user.entity.User;
import com.itmuch.cloud.study.user.service.UserFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FeignClientFallbackFactory implements FallbackFactory<UserFeignClient>{

    private static final Logger LOGGER = LoggerFactory.getLogger(FeignClientFallbackFactory.class);

    @Override
    public UserFeignClient create(Throwable cause) {
        return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                User user = new User();
                if(cause instanceof IllegalArgumentException){
                    user.setId(-1L);
                }else{
                    user.setId(-2L);
                }
                FeignClientFallbackFactory.LOGGER.info("fallback; reason was:", cause);

                user.setUsername("默认用户");

                return user;
            }
        };
    }
}
