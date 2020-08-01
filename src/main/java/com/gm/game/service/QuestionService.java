package com.gm.game.service;

import com.gm.game.dto.AnswerResponseDto;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    public AnswerResponseDto answerQuestion(String questionId, Integer answerNumber){
        Integer questionIdVal = questionId.hashCode();
        if(questionIdVal % 2 == answerNumber % 2){
            return new AnswerResponseDto(questionIdVal % 4 + 1, true);
        }
        return new AnswerResponseDto(0, false);
    }
}
