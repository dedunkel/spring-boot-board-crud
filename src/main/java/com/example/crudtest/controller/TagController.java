package com.example.crudtest.controller;

import com.example.crudtest.entity.Tag;
import com.example.crudtest.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
@RequiredArgsConstructor
public class TagController {

    private final TagService tagService;

    // 태그 추가
    @PostMapping("/{boardId}")
    public void addTag(@PathVariable Long boardId,
                       @RequestParam String name) {
        tagService.addTag(boardId, name);
    }

    // 전체 태그 조회
    @GetMapping
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }

    // 특정 게시글의 태그 조회
    @GetMapping("/{boardId}")
    public List<String> getTagsByBoard(@PathVariable Long boardId) {
        return tagService.getTagsByBoard(boardId);
    }
}