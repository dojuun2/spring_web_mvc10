package com.spring.webmvc.board.service;

import com.spring.webmvc.board.domain.Board;
import com.spring.webmvc.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

// 역할 : 컨트롤러와 레파지토리 사이 중간에서 잡다한 처리를 담당
@RequiredArgsConstructor    // final 필드 초기화 생성자를 만듦
@Service    // bean 등록
public class BoardService {

    // 세터랑 필드주입을 막기 위해 final로 걸고
    private final BoardRepository repository;

    // 생성자 주입을 사용해야함
//    @Autowired    // => 생성자 하나면 생략 가능
//    public BoardService(BoardRepository repository) {
//        this.repository = repository;
//    }

    // 전체 조회 중간처리
    public List<Board> getList() {
        List<Board> boardList = repository.findAll();

        // 게시물 제목 줄임 처리
        // 만약에 글 제목이 6글자 이상이면 6글자 까지만 보여주고 뒤에 ... 처리
        for (Board b : boardList) {
            subStringTitle(b);
            convertDateFormat(b);
        }
        return boardList;
    }
    private void convertDateFormat(Board b) {
        // 날짜 포맷팅 처리
        Date regDate = b.getRegDate();
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd a hh:mm");
        b.setPrettierDate(sdf.format(regDate));
    }
    private void subStringTitle(Board b) {
        String title = b.getTitle();
        if (title.length() > 6){
            String shortTitle = title.substring(0, 6) + "...";
            b.setShortTitle(shortTitle);
        }else{
            b.setShortTitle(title);
        }
    }

    // 상세 조회 중간처리
    public Board getDetail(Long boardNo) {
        Board board = repository.findOne(boardNo);
        return board;
    }

    // 게시물 저장 중간처리
    public boolean insert(Board board) {
        boolean flag = repository.save(board);
        return flag;
    }

    // 게시물 수정 중간처리
    public boolean update(Board board) {
        boolean flag = repository.modify(board);
        return flag;
    }

    // 게시물 삭제 중간처리
    public boolean delete(Long boardNo) {
        boolean flag = repository.remove(boardNo);
        return flag;
    }
}
