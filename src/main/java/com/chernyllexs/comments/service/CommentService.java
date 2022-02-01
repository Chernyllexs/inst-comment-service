package com.chernyllexs.comments.service;

import com.chernyllexs.comments.model.CommentDto;

import java.util.List;

public interface CommentService {
    public CommentDto addComment(CommentDto commentDto);

    public List<CommentDto> getAllComments();

    public List<CommentDto> getCommentsByPostId(Long id);
}
