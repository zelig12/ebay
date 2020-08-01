package com.gm.game.dto;



public class AnswerDto {


    private String userName;
    private String gameId;
    private String questionId;
    private Integer answer;

    public AnswerDto(){
    }

    public AnswerDto(String userName, String gameId, String questionId, Integer answer) {
        this.userName = userName;
        this.gameId = gameId;
        this.questionId = questionId;
        this.answer = answer;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }


}
