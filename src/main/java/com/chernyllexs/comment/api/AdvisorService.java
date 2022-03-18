package com.chernyllexs.comment.api;

import org.springframework.web.context.request.WebRequest;

import java.util.Map;

public interface AdvisorService {
    Map<String, Object> responseBuilder(RuntimeException ex, WebRequest request);
}
