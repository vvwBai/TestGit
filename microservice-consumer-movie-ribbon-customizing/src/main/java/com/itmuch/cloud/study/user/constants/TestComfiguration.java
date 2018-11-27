package com.itmuch.cloud.study.user.constants;


import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(name = "microservice-provide-user", configuration = RibbonConfiguration.class)
public class TestComfiguration {
}
