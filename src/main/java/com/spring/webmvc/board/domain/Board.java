package com.spring.webmvc.board.domain;

import lombok.*;

import java.util.Date;

// DB 엔터티(테이블)과 1:1 매칭되는 Value Object : VO
@Setter
@Getter
@ToString   // toString() 메소드 자동작성
@NoArgsConstructor  // 파라미터가 없는 기본 생성자를 생성
@AllArgsConstructor     // 모든 필드 값을 파라미터로 받는 생성자를 만듦
@Builder
public class Board {
    // int, long같은 자료형은 값이 안넘어올때를 대비해서 참조형으로 작성함
    // int, long은 값이 넘어오지 않으면 기본값이 0... default 0이 되어버림
    // Integer, Long => 기본값 null
    private Long boardNo;   // sql에서 int형이면 999억 => 자바 int형으로는 담을 수 없음
    private String writer;
    private String content;
    private String title;
    private int viewCnt;    // 조회수는 기본값 0
    private Date regDate;

    // 커스텀 필드
    private String shortTitle;  // 줄임 제목
    private String prettierDate;    // 포맷팅한 날짜문자열

    /*private Board(Builder builder) {
        this.boardNo = builder.boardNo;
        this.writer = builder.writer;
        this.content = builder.content;
        this.title = builder.title;
        this.viewCnt = builder.viewCnt;
        this.regDate = builder.regDate;
    }

    public static class Builder {
        private Long boardNo;
        private String writer;
        private String content;
        private String title;
        private int viewCnt;
        private Date regDate;

        public Builder boardNo(Long boardNo) {
            this.boardNo = boardNo;
            return this;
        }

        public Builder writer(String writer) {
            this.writer = writer;
            return this;
        }

        public Builder content(String content) {
            this.content = content;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder viewCnt(int viewCnt) {
            this.viewCnt = viewCnt;
            return this;
        }

        public Builder regDate(Date regDate) {
            this.regDate = regDate;
            return this;
        }

        public Board build() {
            return new Board(this);
        }
    }*/
}
