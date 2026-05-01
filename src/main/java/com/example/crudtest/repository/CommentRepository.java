package com.example.crudtest.repository;

import com.example.crudtest.entity.Board;
import com.example.crudtest.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByBoardId(Long boardId);

    Long board(Board board);
}