package com.example.crudtest.service;

import com.example.crudtest.entity.Board;
import com.example.crudtest.entity.Tag;
import com.example.crudtest.repository.BoardRepository;
import com.example.crudtest.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {
    private final BoardRepository boardRepository;
    private final TagRepository tagRepository;

    // 태그 추가
    public Board addTag(Long boardId, String tagName){
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("게시글 없음"));
        Tag tag = tagRepository.findByName(tagName)
                .orElseGet(() -> tagRepository.save(new Tag()));

        tag.setName(tagName);

        board.getTags().add(tag);
        return boardRepository.save(board);
    }

    // 태그 조회
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }
}
