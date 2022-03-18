package com.chernyllexs.comment.web.controller;

import com.chernyllexs.comment.api.CommentService;
import com.chernyllexs.comment.model.dto.CommentCreateDto;
import com.chernyllexs.comment.model.dto.CommentDto;
import com.chernyllexs.comment.model.dto.PagingCommentDto;
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
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentCreateDto commentCreateDto) {
        return ResponseEntity.ok(commentService.addComment(new CommentDto(commentCreateDto)));
    }

    /*@GetMapping("/get-comments/{postId}")
    public Page<CommentDto> query(@RequestParam String condition,
                                  @RequestParam(required = false,defaultValue = "0") int page,
                                  @RequestParam(required = false,defaultValue = "5") int size){
        return commentService.query(condition,new PageRequest(page,size, Sort.by("")));
    }*/

    @GetMapping("/get-paginated/{postId}/{pageNo}/{pageSize}")
    public ResponseEntity<PagingCommentDto> getPaginatedPost(
            @PathVariable(name = "postId") Long postId,
            @PathVariable(name = "pageNo", required = false) Integer pageNo,
            @PathVariable(name = "pageSize",required = false) Integer pageSize) {
        if (pageNo.equals(null))
            pageNo = new Integer(0);
        if (pageSize.equals(null))
            pageSize = new Integer(5);
        return ResponseEntity.ok().body(commentService.getPaginated(pageNo, pageSize, postId));
    }

    // delete
    @GetMapping("/get-all-comment-for-post/{postId}")
    public List<CommentDto> getAllCommentsForPost(@PathVariable Long postId) {
        return commentService.getAllCommentsByPostId(postId);
    }

    //del
    @GetMapping("/get-five-last-comment-for-post/{postId}")
    public List<CommentDto> getLastFiveCommentsForPost(@PathVariable Long postId) {
        return commentService.getFiveLastCommentsByPostId(postId);
    }

    @DeleteMapping("/delete-all-comments-for-post/{postId}")
    public void deleteAllCommentsByPostId(@PathVariable Long postId) {
        commentService.deleteAllCommentsByPostId(postId);
    }

    @DeleteMapping("/delete-comment/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        commentService.deleteComment(commentId);
    }
}


