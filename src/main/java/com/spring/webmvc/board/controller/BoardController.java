package com.spring.webmvc.board.controller;


import com.spring.webmvc.board.domain.Board;
import com.spring.webmvc.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor    // final 필드 초기화 생성자 주입
@Controller     // 빈 등록
@RequestMapping("/board")   // 공통 url 진입점 설정
@Log4j2 // 로그 라이브러리
public class BoardController {
    private final BoardService service;

    // 게시물 목록 조회 요청 처리
    @GetMapping("/list")
    public String list(Model model){
        int a=10;
        List<Board> boardList = service.getList();
        log.info("/board/list GET! 요청 발생 - {}", a);

        model.addAttribute("bList", boardList);

        return "board/list";
    }
}
