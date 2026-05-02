package com.example.crudtest.service;

import com.example.crudtest.entity.Board;
import com.example.crudtest.entity.Tag;
import com.example.crudtest.entity.BoardTag;
import com.example.crudtest.repository.BoardRepository;
import com.example.crudtest.repository.TagRepository;
import com.example.crudtest.repository.BoardTagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService {

    private final BoardRepository boardRepository;
    private final TagRepository tagRepository;
    private final BoardTagRepository boardTagRepository; // ✅ 추가

    // 태그 추가
    public void addTag(Long boardId, String tagName) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("게시글 없음"));

        Tag tag = tagRepository.findByName(tagName)
                .orElseGet(() -> {
                    Tag newTag = new Tag();
                    newTag.setName(tagName);
                    return tagRepository.save(newTag);
                });

        BoardTag boardTag = new BoardTag();
        boardTag.setBoard(board);
        boardTag.setTag(tag);

        boardTagRepository.save(boardTag); // ✅ 수정
    }

    // 태그 전체 조회
    public List<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    // 특정 게시글의 태그 조회
    public List<String> getTagsByBoard(Long boardId) {
        return boardTagRepository.findByBoardId(boardId)
                .stream()
                .map(boardTag -> boardTag.getTag().getName())
                .toList();
    }
}