package com.example.crudtest.service;

import com.example.crudtest.entity.Board;
import com.example.crudtest.entity.Comment;
import com.example.crudtest.repository.BoardRepository;
import com.example.crudtest.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    // 댓글 생성
    public Comment createComment(Long boardId, Comment comment) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("게시글 없음"));

        comment.setBoard(board);
        return commentRepository.save(comment);
    }

    // 특정 게시글 댓글 조회
    public List<Comment> getComments(Long boardId) {
        return commentRepository.findByBoardId(boardId);
    }
}
