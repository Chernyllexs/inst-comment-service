package com.chernyllexs.comments.controller;

import com.chernyllexs.comments.model.CommentDto;
import com.chernyllexs.comments.service.implementation.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;

    @PostMapping
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto commentDto){
        return ResponseEntity.ok(commentService.addComment(commentDto));
    }

    @GetMapping("/get-all-comment-for-post/{postId}")
    public List<CommentDto> getAllCommentsForPost(@PathVariable Long postId){
        return commentService.getAllCommentsByPostId(postId);
    }

    @GetMapping("/get-five-last-comment-for-post/{postId}")
    public List<CommentDto> getLastFiveCommentsForPost(@PathVariable Long postId){
        return commentService.getFiveLastCommentsByPostId(postId);
    }

    @DeleteMapping("/delete-all-user-comments/{userId}")
    public void deleteAllUserComments(@PathVariable Long userId){
        commentService.deleteAllUserComments(userId);
    }

    @DeleteMapping("/delete-all-comments-for-post/{postId}")
    public void deleteAllCommentsByPostId(@PathVariable Long postId){
        commentService.deleteAllCommentsByPostId(postId);
    }

    @DeleteMapping("/delete-comment/{commentId}")
    public void deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);
    }



}
