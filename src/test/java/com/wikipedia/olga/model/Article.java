package com.wikipedia.olga.model;

public class Article {

    private String articleName;

    public String getArticleName() {
        return articleName;
    }

    public Article withArticleName(String articleName) {
        this.articleName = articleName;
        return this;
    }

    @Override
    public String toString() {
        return "articleName='" + articleName + '\'' +
                '}';
    }
}
