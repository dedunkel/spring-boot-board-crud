package com.example.crudtest.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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

    // 1:1 (BoardDetail)
    @OneToOne(mappedBy = "board", cascade = CascadeType.ALL)
    private BoardDetail boardDetail;

    // 1:N (Comment)
    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
    private List<Comment> comments;

    // M:N (Tag)
    @ManyToMany
    @JoinTable(
            name = "board_tag",
            joinColumns = @JoinColumn(name = "board_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    private List<Tag> tags;
}
