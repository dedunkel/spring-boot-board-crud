package com.example.crudtest.controller;

import com.example.crudtest.entity.Board;
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

    @PostMapping("/{boardId}")
    public Board addTag(@PathVariable Long boardId, @RequestParam String name) {
        return tagService.addTag(boardId, name);
    }

    @GetMapping
    public List<Tag> getAllTags() {
        return tagService.getAllTags();
    }
}