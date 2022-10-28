package com.spring.webmvc.board.controller;


import com.spring.webmvc.board.domain.Board;
import com.spring.webmvc.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        List<Board> boardList = service.getList();
        log.info("/board/list GET!!");



        model.addAttribute("bList", boardList);

        return "board/list";
    }

    // 게시물 상세 조회 요청처리
    @GetMapping("/content/{boardNo}")
    public String content(@PathVariable("boardNo") Long boardNo, Model model){
        log.info("/board/content/{} GET!! ", boardNo);

        Board board = service.getDetail(boardNo);
        model.addAttribute("b", board);
        return "board/detail";
    }

    // 게시물 쓰기 화면 요청
    @GetMapping("/write")
    public String write(){
        log.info("/board/write GET!!");
        return "board/write";
    }

    // 게시물 등록 요청
    @PostMapping("/write")
    public String write(Board board, RedirectAttributes ra){
        log.info("/board/write POST!! - {}", board);

        boolean flag = service.insert(board);
        ra.addFlashAttribute("msg", "insert-success");  // 등록하고 redirect 될때까지만 살아있는다!!
        return flag ? "redirect:/board/list" : "redirect:/";
    }
}


















