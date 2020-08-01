package com.gm.game.dal;

import com.gm.game.model.UserPoints;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class GameBoardDal {//gameId-> userID -> User Points

    private Map<String, Map<String, UserPoints>> gameToUserToPoint;

    public GameBoardDal() {
        gameToUserToPoint = new ConcurrentHashMap<String, Map<String, UserPoints>>();
    }

    public int getUserPoints(String gameId, String userId){
        if(gameToUserToPoint.containsKey(gameId) &&
                gameToUserToPoint.get(gameId).containsKey(userId)){
            return gameToUserToPoint.get(gameId).get(userId).getPoints();
        }
        return 0;
    }

    public void updateUserPoints(String gameId, String userId, int score){
        gameToUserToPoint.putIfAbsent(gameId, new ConcurrentHashMap<>());
        gameToUserToPoint.get(gameId).put(userId, new UserPoints(userId, score));
    }

    public List<UserPoints> getLeaderBoard(String gameId){
        return gameToUserToPoint.containsKey(gameId) ?
                new ArrayList<UserPoints>(gameToUserToPoint.get(gameId).values()) :
                new ArrayList<UserPoints>(0);

    }
}