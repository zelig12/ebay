package com.gm.game.dto;

public class AnswerResponseDto {

    private int points;
    private boolean correct;

    public AnswerResponseDto() {
    }

    public AnswerResponseDto(int points, boolean correct) {
        this.points = points;
        this.correct = correct;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }



}
