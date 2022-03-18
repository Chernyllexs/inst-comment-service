package com.chernyllexs.comment.api;

import com.chernyllexs.comment.model.dto.CommentDto;
import com.chernyllexs.comment.model.dto.PagingCommentDto;

import java.util.List;

public interface CommentService {

    CommentDto addComment(CommentDto commentDto);

    List<CommentDto> getAllCommentsByPostId(Long postId);

    List<CommentDto> getFiveLastCommentsByPostId(Long postId);

    void deleteAllCommentsByPostId(Long postId);

    void deleteComment(Long commentId);

    PagingCommentDto getPaginated(int pageNo, int pageSize, Long postId);
}
