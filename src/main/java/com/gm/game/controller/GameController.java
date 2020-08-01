package com.gm.game.controller;

import com.gm.game.dto.AnswerDto;
import com.gm.game.dto.AnswerResponseDto;
import com.gm.game.dto.UserScoreDto;
import com.gm.game.service.GameManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    private GameManagerService gameManagerService;


    @PutMapping("/answer")
    public AnswerResponseDto answerQuestion(AnswerDto answer) {
        return gameManagerService.answerQuestion(answer);
    }

    @GetMapping("/leaderboard")
    public List<UserScoreDto> getLeaderBoard(String gameId){
        return gameManagerService.getLeaderBoardService(gameId);
    }
}
