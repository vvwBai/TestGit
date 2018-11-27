package com.itmuch.cloud.study.user.config;

import feign.Contract;
import org.springframework.context.annotation.Bean;

public class FeignConfiguration {

    /**
     * 将契约改成feign原生的默认契约。这样就可以使用feign自带的注解了
     * @return 默认的feign契约
     */

    @Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
    }

}
