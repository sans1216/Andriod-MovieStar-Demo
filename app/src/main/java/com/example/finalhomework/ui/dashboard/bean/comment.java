package com.example.finalhomework.ui.dashboard.bean;

public class comment {
    private String username;
    private String content;
    private double score;
    private String title;
    private int icon;
public comment(String username,String title,String content,double score,int icon){
    this.title = title;
    this.content = content;
    this.score = score;
    this.icon = icon;
    this.username = username;
}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public int getIcon() {
        return icon;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUsername() {
        return username;
    }

    public String getContent() {
        return content;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
