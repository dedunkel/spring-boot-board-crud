package com.example.crudtest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)   // null 값 허용 X
    private String title;

    @Column(nullable = false)   // null 값 허용 X
    private String content;

    @Column(nullable = false)   // null 값 허용 X
    private String writer;

    @Column(nullable = true)    // default 값
    private String password;
}
