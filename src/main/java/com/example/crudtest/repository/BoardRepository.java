package com.example.crudtest.repository;

import com.example.crudtest.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>{// JpaRepository<[Entity], [Entity의 PK 타입]>
    List<Board> findByWriter(String writer);
    List<Board> findByTitleContaining(String keyword);
}
// Spring Data JPA를 이용해 DB 작업 자동으로 처리하는 인터페이스

/*
자동 생성되는 함수들
save()        // 저장
findById()    // ID로 조회
findAll()     // 전체 조회
deleteById()  // 삭제
count()       // 개수 조회
*/
