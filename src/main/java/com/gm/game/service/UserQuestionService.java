package com.gm.game.service;

import com.gm.game.dal.UserQuestionDal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class UserQuestionService {

    @Autowired
    private UserQuestionDal userQuestionDal;

    public UserQuestionService() {
    }

    public void addNewQuestion(String userName, String questionId){

        userQuestionDal.addEntry(userName, questionId);
    }

    public Set<String> getQuestions(String userName){
        return userQuestionDal.getQuestions(userName);
    }



}
