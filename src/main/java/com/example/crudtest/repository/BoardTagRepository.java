package com.example.crudtest.repository;

import com.example.crudtest.entity.BoardTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardTagRepository extends JpaRepository<BoardTag, Long> {

    // 특정 게시글에 달린 태그들 조회
    List<BoardTag> findByBoardId(Long boardId);

    // 특정 태그가 사용된 게시글들 조회
    List<BoardTag> findByTagId(Long tagId);
}