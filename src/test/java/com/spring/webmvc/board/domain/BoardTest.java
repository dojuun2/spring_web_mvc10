package com.spring.webmvc.board.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void builderTest(){
        Board board = Board.builder()       // @Build
                                .title("제목이지롱")
                                .boardNo(20L)
                                .content("하하하하하")
                                .writer("wowman")
                                .build();

        System.out.println(board.getTitle());
    }

}