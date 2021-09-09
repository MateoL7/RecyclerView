package com.example.ejerciciorecyclerview;

public class Post {

    private String name;
    private String content;
    private String date;
    private int likes;

    public Post() {
    }

    public Post(String name, String content, String date, int likes) {
        this.name = name;
        this.content = content;
        this.date = date;
        this.likes = likes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}
