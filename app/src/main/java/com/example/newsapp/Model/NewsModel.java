package com.example.newsapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsModel {

    @SerializedName("success")
    @Expose
    private boolean success;

    @SerializedName("message")
    @Expose
    private String message;

    @SerializedName("item")
    @Expose
    private List<NewsItem> item;

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setItem(List<NewsItem> item) {
        this.item = item;
    }

    public List<NewsItem> getItem() {
        return item;
    }

    @Override
    public String toString(){
        return
                "ResponseBerita{" +
                    "success = '" + success + '\'' +
                    ",message = '" + message + '\'' +
                    ",item = '" + item + '\'' +
                    "}";
    }
}
