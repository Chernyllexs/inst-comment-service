package com.chernyllexs.comment.api;

import com.chernyllexs.comment.model.dto.CommentDto;
import com.chernyllexs.comment.model.entity.CommentEntity;

import java.util.ArrayList;

public interface CommentMapper {
    public CommentDto convertToDto(CommentEntity commentEntity);

    public CommentEntity convertToEntity(CommentDto commentDto);

    public ArrayList<CommentDto> convertListToDto(Iterable<CommentEntity> iterable);
}
