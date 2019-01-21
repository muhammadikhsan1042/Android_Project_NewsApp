package com.example.newsapp.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsItem {

    @SerializedName("ID")
    @Expose
    private int ID;

    @SerializedName("Title")
    @Expose
    private String Title;

    @SerializedName("Main")
    @Expose
    private String Main;

    @SerializedName("Image")
    @Expose
    private String Image;

    @SerializedName("Create_Time")
    @Expose
    private String Create_Time;

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTitle() {
        return Title;
    }

    public void setMain(String main) {
        Main = main;
    }

    public String getMain() {
        return Main;
    }

    public void setImage(String image) {
        Image = image;
    }

    public String getImage() {
        return Image;
    }

    public void setCreate_Time(String create_Time) {
        Create_Time = create_Time;
    }

    public String getCreate_Time() {
        return Create_Time;
    }

    @Override
    public String toString(){
        return
                "ResponseBerita{" +
                        "ID = '" + ID + '\'' +
                        ",Title = '" + Title + '\'' +
                        ",Main = '" + Main + '\'' +
                        ",Image = '" + Image + '\'' +
                        ",Create_Time = '" + Create_Time + '\'' +
                        "}";
    }
}
