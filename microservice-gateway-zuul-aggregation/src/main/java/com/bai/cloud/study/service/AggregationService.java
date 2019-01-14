package com.bai.cloud.study.service;

import com.bai.cloud.study.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;


@Service
public class AggregationService {

    @Autowired
    private RestTemplate restTemplate;

    public Observable<User> getUserById(Long id){

        return Observable.create(observer -> {
            User user = restTemplate.getForObject("http://microservice-provider-user/{id}", User.class, id);
            observer.onNext(user);
            observer.onCompleted();
        });

    }


    @HystrixCommand(fallbackMethod = "fallback")
    public Observable<User> getMovieUserByUserId(Long id){
        return Observable.create(observer -> {
           //请求电影微服务的/user/{id}端点
            User movieUser = restTemplate.getForObject("http://microservice-consumer-movie/user/{id}", User.class, id);
            observer.onNext(movieUser);
            observer.onCompleted();

        });
    }


    public User fallback(Long id){
        User user = new User();
        user.setId(-1L);
        return user;
    }


}
