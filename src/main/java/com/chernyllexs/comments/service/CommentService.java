package com.chernyllexs.comments.service;

import com.chernyllexs.comments.model.CommentDto;

import java.util.List;

public interface CommentService {

    public CommentDto addComment(CommentDto commentDto);

    public List<CommentDto> getAllCommentsByPostId(Long postId);

    public List<CommentDto> getFiveLastCommentsByPostId(Long postId);

    public void deleteAllUserComments(Long userId);

    public void deleteAllCommentsByPostId(Long postId);

    public void deleteComment(Long commentId);

}
