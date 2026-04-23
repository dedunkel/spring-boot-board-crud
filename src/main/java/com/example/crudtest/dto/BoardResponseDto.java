package com.example.crudtest.dto;

import lombok.Getter;
import lombok.AllArgsConstructor;

@Getter
@AllArgsConstructor
public class BoardResponseDto {
    private Long id;
    private String title;
    private String content;
    private String writer;
}


/*
public class BoardResponseDto {

    private Long id;
    private String title;
    private String content;
    private String writer;

    public BoardResponseDto(Long id, String title, String content, String writer) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
}
*/