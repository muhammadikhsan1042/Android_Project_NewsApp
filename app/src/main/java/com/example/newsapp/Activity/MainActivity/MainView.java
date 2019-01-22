package com.example.newsapp.Activity.MainActivity;

import com.example.newsapp.Classes.SearchClasses.MaterialSearchView;
import com.example.newsapp.Model.NewsItem;

import java.util.List;

public interface MainView
        extends MaterialSearchView.OnQueryTextListener, MaterialSearchView.SearchViewListener{

    void successGetItem(List<NewsItem> NewsItem);
    void failedGetItem(String message);
}
