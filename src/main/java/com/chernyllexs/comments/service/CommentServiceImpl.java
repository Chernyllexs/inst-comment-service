package com.chernyllexs.comments.service;

import com.chernyllexs.comments.entity.CommentEntity;
import com.chernyllexs.comments.model.CommentDto;
import com.chernyllexs.comments.repository.CommentRepository;
import com.chernyllexs.comments.service.CommentService;
import com.chernyllexs.comments.utill.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public CommentDto addComment(CommentDto commentDto) {
        commentDto.setCommentDate(LocalDateTime.now());
        return commentMapper.convertToDto(commentRepository.save(commentMapper.convertToEntity(commentDto)));
    }

    @Override
    public List<CommentDto> getAllComments() {
        Iterable<CommentEntity> iterable = commentRepository.findAll();
        ArrayList<CommentDto> commentsDto = new ArrayList<>();
        for(CommentEntity entity: iterable)
            commentsDto.add(commentMapper.convertToDto(entity));
        return commentsDto;
    }

    @Override
    public List<CommentDto> getCommentsByPostId(Long id) {
        Iterable<CommentEntity> commentEntityList = commentRepository.findByPostIdOrderByCommentDate(id);
        ArrayList<CommentDto> commentsDto = new ArrayList<>();
        for(CommentEntity entity: commentEntityList)
            commentsDto.add(commentMapper.convertToDto(entity));
        return commentsDto;
    }
}
