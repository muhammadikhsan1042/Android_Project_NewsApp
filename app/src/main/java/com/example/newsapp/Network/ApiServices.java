package com.example.newsapp.Network;

import com.example.newsapp.Model.NewsModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiServices {

    @GET("GetNews.php")
    Call<NewsModel>newsRequest();


}
