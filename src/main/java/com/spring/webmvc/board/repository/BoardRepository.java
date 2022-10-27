package com.spring.webmvc.board.repository;

import com.spring.webmvc.board.domain.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

// 역할 : 게시물 데이터를 저장, 조회, 수정, 삭제하는 책임을 부여받음
// SQL Mapper 인터페이스
@Mapper     // 얘를 붙이면 com/spring/webmvc/board/repository/BoardRepository.xml과 자동매핑이 됨
public interface BoardRepository {

    // 게시글 목록 조회
    public abstract List<Board> findAll();   // 추상메소드는 앞에 public abstract 생략 가능

    // 게시글 상세 단일 조회
    Board findOne(Long boardNo);

    // 게시글 쓰기
    boolean save(Board board);

    // 게시글 삭제
    boolean remove(Long boardNo);

    // 게시글 수정
    boolean modify(Board board);
}