package com.example.crudtest.controller;

import com.example.crudtest.entity.Comment;
import com.example.crudtest.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/{boardId}")
    public Comment createComment(@PathVariable Long boardId, @RequestBody Comment comment) {
        return commentService.createComment(boardId, comment);
    }

    @GetMapping("/{boardId}")
    public List<Comment> getComments(@PathVariable Long boardId) {
        return commentService.getComments(boardId);
    }

}
