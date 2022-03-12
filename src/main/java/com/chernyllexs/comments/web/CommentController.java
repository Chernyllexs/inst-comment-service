package com.chernyllexs.comments.web;

import com.chernyllexs.comments.model.dto.CommentCreateDto;
import com.chernyllexs.comments.model.dto.CommentDto;
import com.chernyllexs.comments.api.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "/api/comment")
@CrossOrigin(origins = "*")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/create-comment")
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentCreateDto commentCreateDto){
        return ResponseEntity.ok(commentService.addComment(new CommentDto(commentCreateDto)));
    }
// delete
    @GetMapping("/get-all-comment-for-post/{postId}")
    public List<CommentDto> getAllCommentsForPost(@PathVariable Long postId){
        return commentService.getAllCommentsByPostId(postId);
    }

    @GetMapping("/get-five-last-comment-for-post/{postId}")
    public List<CommentDto> getLastFiveCommentsForPost(@PathVariable Long postId){
        return commentService.getFiveLastCommentsByPostId(postId);
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
