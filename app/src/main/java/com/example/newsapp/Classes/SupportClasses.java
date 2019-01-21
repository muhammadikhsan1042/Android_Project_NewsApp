package com.example.newsapp.Classes;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SupportClasses extends AppCompatActivity {

    public Context context;
    protected ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context=SupportClasses.this;
    }

    public void simpleIntent(Class dest){
        Intent move = new Intent(context, dest);
        startActivity(move);
    }

    public void progresDialog(){
        progressDialog = ProgressDialog.show(context, null, "Loading...", true, false);
    }

}
