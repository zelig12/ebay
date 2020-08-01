package com.gm.game.service;

import com.gm.game.dal.GameBoardDal;
import com.gm.game.dto.AnswerDto;
import com.gm.game.dto.AnswerResponseDto;
import com.gm.game.dto.UserScoreDto;
import com.gm.game.model.UserPoints;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class GameBoardServiceTest {

    @Autowired
    GameBoardService gameBoardService;


    private AnswerResponseDto ansResponseDtoWithPoints = new AnswerResponseDto(1, true);
    private AnswerResponseDto ansResponseDtoNoPoints = new AnswerResponseDto(0, false);

    @Test
    void addPointToNewGame() {
        AnswerDto ansGame1User1 = new AnswerDto("u1", "g1", "q1", 1);
        gameBoardService.updateBoard(ansGame1User1, ansResponseDtoWithPoints);
        assertEquals(gameBoardService.getUserScore(ansGame1User1), 1);
    }

    @Test
    void addPointToExistingGameNewUser() {
        AnswerDto ansGame2User2 = new AnswerDto("u2", "g2", "q2", 1);
        AnswerDto ansGame2User3 = new AnswerDto("u3", "g2", "q2", 1);
        gameBoardService.updateBoard(ansGame2User2, ansResponseDtoWithPoints);
        gameBoardService.updateBoard(ansGame2User3, ansResponseDtoWithPoints);
        assertEquals(gameBoardService.getUserScore(ansGame2User2), 1);
        assertEquals(gameBoardService.getUserScore(ansGame2User3), 1);

    }

    @Test
    void addPointToExistingGameExistingUser() {
        AnswerDto ansGame3User4Q1 = new AnswerDto("u4", "g3", "q1", 1);
        AnswerDto ansGame3User4Q2 = new AnswerDto("u4", "g3", "q2", 1);
        gameBoardService.updateBoard(ansGame3User4Q1, ansResponseDtoWithPoints);
        assertEquals(gameBoardService.getUserScore(ansGame3User4Q1), 1);
        gameBoardService.updateBoard(ansGame3User4Q2, ansResponseDtoWithPoints);
        assertEquals(gameBoardService.getUserScore(ansGame3User4Q1), 2);

    }

    @Test
    void noNeedToUpdateBoard() {
        AnswerDto ansGame4User5Q7 = new AnswerDto("u5", "g4", "q7", 1);
        AnswerDto ansGame4User5Q8 = new AnswerDto("u5", "g4", "q8", 1);
        gameBoardService.updateBoard(ansGame4User5Q7, ansResponseDtoWithPoints);
        assertEquals(gameBoardService.getUserScore(ansGame4User5Q7), 1);
        gameBoardService.updateBoard(ansGame4User5Q8, ansResponseDtoNoPoints);
        assertEquals(gameBoardService.getUserScore(ansGame4User5Q8), 1);
    }

    @Test
    void getEmptyLeaderBoard(){
        assertEquals(gameBoardService.getLeaderBord("g3").size(), 0);
    }

    @Test
    void sortedLeaderBoard(){
        AnswerDto ansGame2User2 = new AnswerDto("u22", "g22", "q22", 1);
        AnswerDto ansGame2User2Q3 = new AnswerDto("u22", "g22", "q23", 1);
        AnswerDto ansGame2User3 = new AnswerDto("u23", "g22", "q22", 1);
        gameBoardService.updateBoard(ansGame2User2, ansResponseDtoWithPoints);
        gameBoardService.updateBoard(ansGame2User2Q3, ansResponseDtoWithPoints);
        gameBoardService.updateBoard(ansGame2User3, ansResponseDtoWithPoints);

        List<UserScoreDto> res = gameBoardService.getLeaderBord("g22");
        assertEquals(res.size(), 2);
        assert res.get(0).getScore() > res.get(1).getScore();
    }


}