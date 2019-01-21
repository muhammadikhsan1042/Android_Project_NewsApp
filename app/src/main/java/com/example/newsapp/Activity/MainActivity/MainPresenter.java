package com.example.newsapp.Activity.MainActivity;

import android.util.Log;

import com.example.newsapp.Model.NewsItem;
import com.example.newsapp.Model.NewsModel;
import com.example.newsapp.Network.InitRetrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {

    private MainView mainView;

    public MainPresenter (MainView mainView){
        this.mainView = mainView;
    }

    public void initData(){
        final String TAG ="MAIN-INIT-DATA";
        InitRetrofit.getInstance()
                .newsRequest()
                .enqueue(new Callback<NewsModel>() {
                    @Override
                    public void onResponse(Call<NewsModel> call, Response<NewsModel> response) {
                        if (response.isSuccessful()){
                            Log.d(TAG, response.body().toString());
                            if (response.body().isSuccess()){
                                List<NewsItem> Item = response.body().getItem();
                                mainView.successGetItem(Item);
                            } else {
                                mainView.failedGetItem("Internal server error");
                            }
                        } else {
                            mainView.failedGetItem("Internal server error");
                        }
                    }
                    @Override
                    public void onFailure(Call<NewsModel> call, Throwable t) {
                        mainView.failedGetItem("Internal server error");
                    }
                });
    }

}
