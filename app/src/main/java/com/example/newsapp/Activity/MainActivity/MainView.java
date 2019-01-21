package com.example.newsapp.Activity.MainActivity;

import com.example.newsapp.Model.NewsItem;

import java.util.List;

public interface MainView {
    void successGetItem(List<NewsItem> NewsItem);
    void failedGetItem(String message);
}
