package com.chernyllexs.comments.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class CommentDto {
    private Long commentId;
    private Long postId;
    private Long userId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss.SSS")
    private LocalDateTime commentDate;
    private String commentText;

    public CommentDto() {
    }

    public CommentDto(Long commentId, Long postId, Long userId, LocalDateTime commentDate, String commentText) {
        this.commentId = commentId;
        this.postId = postId;
        this.userId = userId;
        this.commentDate = commentDate;
        this.commentText = commentText;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
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

    public LocalDateTime getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(LocalDateTime commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "commentId=" + commentId +
                ", postId=" + postId +
                ", userId=" + userId +
                ", commentDate=" + commentDate +
                ", commentText='" + commentText + '\'' +
                '}';
    }
}
