package com.gm.game.service;

import com.gm.game.dal.GameBoardDal;
import com.gm.game.dto.AnswerDto;
import com.gm.game.dto.AnswerResponseDto;
import com.gm.game.dto.UserScoreDto;
import com.gm.game.model.UserPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class GameBoardService {

    @Autowired
    private GameBoardDal gameBoardDal;


    public void updateBoard(AnswerDto answer, AnswerResponseDto ansResponse) {
        if(ansResponse.getPoints() == 0){
            return;
        }
        int points = gameBoardDal.getUserPoints(answer.getGameId(), answer.getUserName());
        gameBoardDal.updateUserPoints(answer.getGameId(), answer.getUserName(), points + ansResponse.getPoints());
    }

    public int getUserScore(AnswerDto answer){
        return gameBoardDal.getUserPoints(answer.getGameId(), answer.getUserName());
    }

    public List<UserScoreDto> getLeaderBord(String gameId){
        List<UserPoints> userPoints = gameBoardDal.getLeaderBoard(gameId);
        Collections.sort(userPoints, Collections.reverseOrder());
        List<UserScoreDto> res = new ArrayList<>(userPoints.size());
        userPoints.forEach(userPoint -> {
            res.add(new UserScoreDto(userPoint.getUserId(), userPoint.getPoints()));
        });
        return res;
    }

}
