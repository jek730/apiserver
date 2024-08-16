package com.jmt.board.services;

import com.jmt.board.controllers.RequestBoard;
import com.jmt.board.entities.Board;
import com.jmt.board.entities.BoardData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
//@ActiveProfiles("test")
public class BoardSaveServiceTest {

    @Autowired
    private BoardSaveService saveService;

    private Board board;

    @BeforeEach
    void init() {
        board = new Board();
        board.setBid("freetalk");
        board.setBName("자유게시판");
    }

    @Test
    void saveTest() {
        RequestBoard form = new RequestBoard();
        form.setBid(board.getBid());
        form.setCategory("분류1");
        form.setPoster("작성자");
        form.setSubject("제목");
        form.setContent("내용");
        form.setGuestPw("1234ab");

        BoardData data = saveService.save(form);
        System.out.println(data);

        form.setMode("update");
        form.setSeq(data.getSeq());

        BoardData data2 = saveService.save(form);
        System.out.println(data2);
    }
}
