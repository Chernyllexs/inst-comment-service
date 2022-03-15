package com.chernyllexs.comment.api;

import com.chernyllexs.comment.model.dto.CommentDto;

import java.util.List;

public interface CommentService {

    public CommentDto addComment(CommentDto commentDto);

    public List<CommentDto> getAllCommentsByPostId(Long postId);

    public List<CommentDto> getFiveLastCommentsByPostId(Long postId);

    public void deleteAllCommentsByPostId(Long postId);

    public void deleteComment(Long commentId);

}