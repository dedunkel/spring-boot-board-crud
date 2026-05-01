package com.example.crudtest.controller;

import com.example.crudtest.entity.BoardDetail;
import com.example.crudtest.service.BoardDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/details")
@RequiredArgsConstructor
public class BoardDetailController {

    private final BoardDetailService boardDetailService;

    @PostMapping("/{boardId}")
    public BoardDetail createDetail(@PathVariable Long boardId,
                                    @RequestBody BoardDetail detail) {
        return boardDetailService.createDetail(boardId, detail);
    }
}