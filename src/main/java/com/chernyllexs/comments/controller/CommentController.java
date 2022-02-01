package com.chernyllexs.comments.controller;

import com.chernyllexs.comments.model.CommentDto;
import com.chernyllexs.comments.service.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;

    @PostMapping
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto commentDto){
        return ResponseEntity.ok(commentService.addComment(commentDto));
    }

    @GetMapping
    public List<CommentDto> getAllComments(){
        return commentService.getAllComments();
    }

    @GetMapping("/getComment/{id}")
    public ResponseEntity<List<CommentDto>> getCommentByPostId(@PathVariable Long id){
        return ResponseEntity.ok(commentService.getCommentsByPostId(id));
    }

}
