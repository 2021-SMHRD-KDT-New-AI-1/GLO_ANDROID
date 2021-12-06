package com.nsg.glo3;

public class recomand {
    String content;
    String category;
    String title;
    int score;

    public recomand(String content, String title, String category, int score) {
        this.content = content;
        this.title = title;
        this.category = category;
        this.score = score;
    }

    public String getUrl() {
        return content;
    }

    public void setUrl(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
