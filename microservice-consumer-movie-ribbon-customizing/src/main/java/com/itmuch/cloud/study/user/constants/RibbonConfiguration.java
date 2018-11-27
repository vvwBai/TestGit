package com.itmuch.cloud.study.user.constants;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 *  该类为Ribbon的配置类
 *
 */
@Configuration
public class RibbonConfiguration {

    @Bean
    public IRule ribbonRule(){
        //负载均衡的规则，改为随机
        return new RandomRule();
    }
}
