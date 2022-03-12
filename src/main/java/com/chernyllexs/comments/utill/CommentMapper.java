package com.chernyllexs.comments.utill;

import com.chernyllexs.comments.model.entity.CommentEntity;
import com.chernyllexs.comments.model.dto.CommentDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CommentMapper {
    @Autowired
    private ModelMapper modelMapper;

    public CommentDto convertToDto(CommentEntity commentEntity){
        return Objects.isNull(commentEntity) ? null : modelMapper.map(commentEntity, CommentDto.class );
    }

    public CommentEntity convertToEntity(CommentDto commentDto){
        return Objects.isNull(commentDto) ? null : modelMapper.map(commentDto, CommentEntity.class);
    }
}
