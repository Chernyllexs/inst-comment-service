package com.chernyllexs.comments.model.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments", schema = "PUBLIC")
public class CommentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @Column(name = "post_id")
    private Long postId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "comment_created", updatable = false)
    private LocalDateTime commentDate;

    @Column(name = "comment_text")
    private String commentText;

    public CommentEntity() {
    }

    public CommentEntity(Long commentId, Long postId, Long userId, LocalDateTime commentDate, String commentText) {
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
        return "CommentEntity{" +
                "commentId=" + commentId +
                ", postId=" + postId +
                ", userId=" + userId +
                ", commentDate=" + commentDate +
                ", commentText='" + commentText + '\'' +
                '}';
    }
}
