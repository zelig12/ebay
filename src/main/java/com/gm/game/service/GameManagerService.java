package com.gm.game.service;

import com.gm.game.dto.AnswerDto;
import com.gm.game.dto.AnswerResponseDto;
import com.gm.game.dto.UserScoreDto;
import com.gm.game.model.UserPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameManagerService {

    @Autowired
    private UserQuestionService userQuestionService;
    @Autowired
    private QuestionService questionService;
    @Autowired
    private GameBoardService gameBoardService;

    public AnswerResponseDto answerQuestion(AnswerDto answer) {
        userQuestionService.addNewQuestion(answer.getUserName(), answer.getQuestionId());
        AnswerResponseDto ansResponse = questionService.answerQuestion(answer.getQuestionId(), answer.getAnswer());
        gameBoardService.updateBoard(answer, ansResponse);
        return ansResponse;
    }

    public List<UserScoreDto> getLeaderBoardService(String gameId) {
        return gameBoardService.getLeaderBord(gameId);
    }
}
