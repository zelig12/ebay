package com.gm.game.dal;

import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserQuestionDal {

    private Map<String, Set<String>> userToQuestionMap;

    public UserQuestionDal() {
        this.userToQuestionMap = new ConcurrentHashMap<>();;
    }

    public void addEntry(String userName, String questionId) {
        userToQuestionMap.putIfAbsent(userName, new HashSet<>());;
        userToQuestionMap.get(userName).add(questionId);
    }

    public Set<String> getQuestions(String userName){
        return this.userToQuestionMap.get(userName);
    }
}
