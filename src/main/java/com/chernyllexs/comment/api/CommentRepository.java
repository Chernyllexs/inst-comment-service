package com.chernyllexs.comment.api;

import com.chernyllexs.comment.model.entity.CommentEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends CrudRepository<CommentEntity, Long> {

    Iterable<CommentEntity> findByPostIdOrderByCommentDate(Long id);

    @Query(value = "SELECT * FROM comments c WHERE c.post_id = :id ORDER BY c.comment_created DESC LIMIT 5", nativeQuery = true)
    Iterable<CommentEntity> getFiveLastCommentsByPostId(@Param("id") Long id);

    Long deleteByPostId(Long postId);

    Long deleteByCommentId(Long commentId);
}
