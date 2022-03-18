package com.chernyllexs.comment.impl;


import com.chernyllexs.comment.api.AdvisorService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class AdvisorServiceImpl implements AdvisorService {
    @Override
    public Map<String, Object> responseBuilder(RuntimeException ex, WebRequest request){
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        return body;
    }
}
