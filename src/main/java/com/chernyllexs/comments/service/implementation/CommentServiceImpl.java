package com.chernyllexs.comments.service.implementation;

import com.chernyllexs.comments.entity.CommentEntity;
import com.chernyllexs.comments.model.CommentDto;
import com.chernyllexs.comments.repository.CommentRepository;
import com.chernyllexs.comments.service.CommentService;
import com.chernyllexs.comments.service.PostService;
import com.chernyllexs.comments.utill.exception.PostNotFoundException;
import com.chernyllexs.comments.utill.mapper.CommentMapper;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.ArrayList;
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
        if(!postService.postIsExists(commentDto.getPostId()))
            throw new PostNotFoundException("Post id = " + commentDto.getPostId() + " not found" );

        commentDto.setCommentDate(LocalDateTime.now());
        return commentMapper.convertToDto(commentRepository.save(commentMapper.convertToEntity(commentDto)));
    }

    @Override
    public List<CommentDto> getAllCommentsByPostId(Long postId) {
        return listMapper(commentRepository.findByPostIdOrderByCommentDate(postId));
    }

    @Override
    public List<CommentDto> getFiveLastCommentsByPostId(Long postId) {
        return Lists.reverse(listMapper(commentRepository.getFiveLastCommentsByPostId(postId)));
    }

    @Override
    @Transactional
    public void deleteAllUserComments(Long userId) {
        commentRepository.deleteByUserId(userId);
    }

    @Override
    @Transactional
    public void deleteAllCommentsByPostId(Long postId) {
        commentRepository.deleteByPostId(postId);
    }

    @Override
    @Transactional
    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }

    private List<CommentDto> listMapper(Iterable<CommentEntity> iterable) {
        List<CommentDto> scoresDto = new ArrayList<>();
        for (CommentEntity entity : iterable)
            scoresDto.add(commentMapper.convertToDto(entity));
        return scoresDto;
    }
}
