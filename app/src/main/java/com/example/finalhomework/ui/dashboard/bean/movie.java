package com.example.finalhomework.ui.dashboard.bean;

import cn.bmob.v3.BmobObject;

public class movie extends BmobObject {
    String name;
    String intro;
    String date;
    double score;
    int poster;

    public movie(String name,String intro,String date,double score,int poster){
        this.date = date;
        this.intro = intro;
        this.score = score;
        this.name = name;
        this.poster = poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }

    public int getPoster() {
        return poster;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void setScore(double score) {
        this.score = score;
    }

}
