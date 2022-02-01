package com.chernyllexs.comments.repository;

import com.chernyllexs.comments.entity.CommentEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends CrudRepository<CommentEntity, Long> {
    //Optional<List<CommentEntity>> findByPostIdWithOrderByCommentDate(Long id);
    Iterable<CommentEntity> findByPostIdOrderByCommentDate(Long id);
}
