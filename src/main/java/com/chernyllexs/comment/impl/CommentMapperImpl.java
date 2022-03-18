package com.chernyllexs.comment.impl;

import com.chernyllexs.comment.api.CommentMapper;
import com.chernyllexs.comment.model.entity.CommentEntity;
import com.chernyllexs.comment.model.dto.CommentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Objects;

@Component
public class CommentMapperImpl implements CommentMapper {
    @Autowired
    private ModelMapper modelMapper;

    public CommentDto convertToDto(CommentEntity commentEntity){
        return Objects.isNull(commentEntity) ? null : modelMapper.map(commentEntity, CommentDto.class );
    }

    public CommentEntity convertToEntity(CommentDto commentDto){
        return Objects.isNull(commentDto) ? null : modelMapper.map(commentDto, CommentEntity.class);
    }

    @Override
    public ArrayList<CommentDto> convertListToDto(Iterable<CommentEntity> iterable) {
        ArrayList<CommentDto> commentDtos = new ArrayList<>();
        for(CommentEntity commentEntity: iterable){
            commentDtos.add(convertToDto(commentEntity));
        }
        return commentDtos;
    }
}
