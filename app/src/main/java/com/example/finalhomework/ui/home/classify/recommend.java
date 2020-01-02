package com.example.finalhomework.ui.home.classify;

import android.net.Uri;

import java.net.URI;

public class recommend {
    private String nickname;
    private int icon;
    private String tag;
    private String content;
    private Uri img;
    private String date;
    public recommend(String nickname, int icon, String tag, String content, Uri img, String date){
        this.nickname = nickname;
        this.icon = icon;
        this.tag = tag;
        this.content = content;
        this.img = img;
        this.date = date;
    }
    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getContent() {
        return content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Uri getImg() {
        return img;
    }



    public String getNickname() {
        return nickname;
    }

    public String getTag() {
        return tag;
    }


    public void setContent(String content) {
        this.content = content;
    }

    public void setImg(Uri img) {
        this.img = img;
    }


    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }


}

