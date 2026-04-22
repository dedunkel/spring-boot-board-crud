package com.example.crudtest.service;

import com.example.crudtest.entity.Board;
import com.example.crudtest.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    private final BoardRepository boardRepository;  // 생성자 주입

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // CREATE (생성)
    public Board createBoard(Board board) {
        return boardRepository.save(board);
    }

    // READ (조회)
    public List<Board> gotAllBoards() {
        return boardRepository.findAll();
    }

    public Board gotBoardById(Long id) {
        return boardRepository.findById(id).orElse(null);
    }

    public List<Board> gotBoardByWriter(String writer) {
        return boardRepository.findByWriter(writer);
    }

    public List<Board> searchBoards(String keyword) {
        return boardRepository.findByTitleContaining(keyword);
    }

    // UPDATE (수정)
    public Board updateBoard(Long id, Board newboard) {
        Board existingBoard = gotBoardById(id);
        existingBoard.setTitle(newboard.getTitle());
        existingBoard.setContent(newboard.getContent());
        existingBoard.setWriter(newboard.getWriter());
        existingBoard.setPassword(newboard.getPassword());

        return boardRepository.save(existingBoard);
    }

    // DELETE (삭제)
    public boolean deleteBoard(Long id) {
        Board existingBoard = boardRepository.findById(id).orElse(null);

        if (existingBoard != null) {
            boardRepository.delete(existingBoard);
            return true;
        }
        return false;
    }
}
