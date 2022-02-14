package com.chernyllexs.comments.service.implementation;

import com.chernyllexs.comments.service.PostService;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PostServiceImpl implements PostService {
    private final RestTemplate restTemplate;

    public PostServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public Boolean postIsExists(Long postId) {
        String url = "http://GATEWAY-SERVICE:9000/post/check-post/{postId}";
        ResponseEntity<Boolean> response = this.restTemplate.getForEntity(url, Boolean.class, postId);
        if(response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }
}
