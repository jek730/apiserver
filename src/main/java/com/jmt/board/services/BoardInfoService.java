package com.jmt.board.services;

import com.jmt.board.entities.BoardData;
import com.jmt.board.entities.QBoardData;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardInfoService {

    private final JPAQueryFactory jpaQueryFactory;

    public List<BoardData> getAllBoardData() {
        QBoardData boardData = QBoardData.boardData;

        List<BoardData> items = jpaQueryFactory.selectFrom(boardData)
                .leftJoin(boardData.board)
                .fetchJoin()
                .leftJoin(boardData.member)
                .fetchJoin()
                .fetch();
        return items;
        /*
        items.forEach(item -> {

            Member member = item.getMember();
            if (member != null) member.getEmail();

            item.setMember(member);

            Board board = item.getBoard();
            if (board != null) board.getBid();
            item.setBoard(board);
        });
        */
    }


}
