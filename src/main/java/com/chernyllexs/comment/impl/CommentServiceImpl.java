package com.chernyllexs.comment.impl;

import com.chernyllexs.comment.api.CommentMapper;
import com.chernyllexs.comment.api.CommentRepository;
import com.chernyllexs.comment.api.CommentService;
import com.chernyllexs.comment.api.PostService;
import com.chernyllexs.comment.api.exception.CommentNotFoundException;
import com.chernyllexs.comment.api.exception.InvalidCommentException;
import com.chernyllexs.comment.api.exception.PostNotFoundException;
import com.chernyllexs.comment.model.dto.CommentDto;
import com.chernyllexs.comment.model.dto.PagingCommentDto;
import com.chernyllexs.comment.model.entity.CommentEntity;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private PostService postService;


    @Override
    public CommentDto addComment(CommentDto commentDto) {
        if (!postService.postIsExists(commentDto.getPostId()))
            throw new PostNotFoundException("Post id = " + commentDto.getPostId() + " not found");
        if (commentDto.getCommentText().trim().length() < 3)
            throw new InvalidCommentException("The comment text is too short!");

        commentDto.setCommentDate(LocalDateTime.now());
        return commentMapper.convertToDto(commentRepository.save(commentMapper.convertToEntity(commentDto)));
    }

    //del
    @Override
    public List<CommentDto> getAllCommentsByPostId(Long postId) {
        List<CommentDto> commentDtos = commentMapper.convertListToDto(commentRepository.findByPostIdOrderByCommentDate(postId));
        if (commentDtos.isEmpty())
            throw new CommentNotFoundException("The list of comments is empty!");
        return commentDtos;
    }

    //del
    @Override
    public List<CommentDto> getFiveLastCommentsByPostId(Long postId) {
        return Lists.reverse(commentMapper.convertListToDto(commentRepository.getFiveLastCommentsByPostId(postId)));
    }

    @Override
    @Transactional
    public void deleteAllCommentsByPostId(Long postId) {
        if (commentRepository.deleteByPostId(postId) == 0) {
            throw new CommentNotFoundException("Nothing could be deleted!");
        }
    }

    @Override
    @Transactional
    public void deleteComment(Long commentId) {
        if (commentRepository.deleteByCommentId(commentId) == 0) {
            throw new CommentNotFoundException("Nothing could be deleted!");
        }
    }

    @Override
    public PagingCommentDto getPaginated(int pageNo, int pageSize, Long postId) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<CommentEntity> pagedResult = commentRepository.findByPostId(postId, paging);

        PagingCommentDto pagingCommentDto = PagingCommentDto.newBuilder()
                .setCurrentPage(pageNo)
                .setCommentsPerPage(pageSize)
                .setNumberOfComments(commentRepository.countByPostId(postId))
                .setComments(commentMapper.convertListToDto(pagedResult.toList()))
                .build();
        return pagingCommentDto;
    }


}
