package com.chernyllexs.comments.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class CommentCreateDto {
    private Long postId;
    private Long userId;
    private String commentText;

    public CommentCreateDto() {
    }

    public CommentCreateDto(Long postId, Long userId, String commentText) {
        this.postId = postId;
        this.userId = userId;
        this.commentText = commentText;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    @Override
    public String toString() {
        return "CommentCreateDto{" +
                "postId=" + postId +
                ", userId=" + userId +
                ", commentText='" + commentText + '\'' +
                '}';
    }
}

