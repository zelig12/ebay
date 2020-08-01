package com.gm.game.model;

public class UserPoints implements Comparable<UserPoints>{

    private String userId;
    private int points = 0;

    public UserPoints(){
    }
    public UserPoints(String userId, int points) {
        this.userId = userId;
        this.points = points;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }


    @Override
    public int compareTo(UserPoints o) {
        return Double.valueOf(this.getPoints()).compareTo(Double.valueOf(o.getPoints()));
    }
}
