package com.chernyllexs.comments.api;

import com.chernyllexs.comments.model.entity.CommentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends CrudRepository<CommentEntity, Long> {

    Iterable<CommentEntity> findByPostIdOrderByCommentDate(Long id);

    @Query(value = "SELECT * FROM comments c WHERE c.post_id = :id ORDER BY c.comment_created DESC LIMIT 5", nativeQuery = true)
    Iterable<CommentEntity> getFiveLastCommentsByPostId(@Param("id") Long id);

    Long deleteByUserId(Long userId);

    Long deleteByPostId(Long postId);

}
