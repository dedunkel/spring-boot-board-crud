package com.example.crudtest.repository;

import com.example.crudtest.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    // 특정 게시글의 댓글 조회
    List<Comment> findByBoardId(Long boardId);
}