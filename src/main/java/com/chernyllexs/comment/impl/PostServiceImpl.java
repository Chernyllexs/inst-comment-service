package com.chernyllexs.comment.impl;

import com.chernyllexs.comment.api.PostService;
import com.chernyllexs.comment.api.exception.PostNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private final RestTemplate restTemplate;
    @Autowired
    private DiscoveryClient discoveryClient;

    public PostServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Boolean postIsExists(Long postId) {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("INST-POST-SERVICE");
        String url = "http://" + serviceInstances.get(0).getHost() + ":" + serviceInstances.get(0).getPort();
        ResponseEntity<Boolean> response = this.restTemplate.getForEntity(url+ "/api/post/check-post/{postId}", Boolean.class, postId);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            throw new PostNotFoundException("Bad request to post service");
        }
    }
}
