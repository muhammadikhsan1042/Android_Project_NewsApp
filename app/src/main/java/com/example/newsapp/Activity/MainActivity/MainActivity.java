package com.example.newsapp.Activity.MainActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.newsapp.Adapter.MainAdapter;
import com.example.newsapp.Classes.SharedPrefManager;
import com.example.newsapp.Classes.SupportClasses;
import com.example.newsapp.Model.NewsItem;
import com.example.newsapp.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends SupportClasses
        implements NavigationView.OnNavigationItemSelectedListener, MainView {

    // Deklarasi Variable
    private final static String TAG = MainActivity.class.getSimpleName();
    private MainPresenter mainPresenter;
    Context mContext;
    SharedPrefManager Session;
    View mView;

    //Deklarasi View
    @BindView(R.id.RV_Main)
    RecyclerView RV_Main;
    @BindView(R.id.SR_Main)
    SwipeRefreshLayout SR_Main;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer_layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initItem();
    }

    public void initItem(){
        initView();
        initNav();
        initVar();
        initPresenter();
        initDataPresenter();
    }

    private void initView() {
        ButterKnife.bind(this);
        RV_Main = findViewById(R.id.RV_Main);
        RV_Main.setLayoutManager(new LinearLayoutManager(mContext));
    }

    private void initPresenter() {
        mainPresenter = new MainPresenter((MainView) mContext);
    }

    private void initDataPresenter(){
        mainPresenter.initData();
    }

    private void initVar(){
        Session = new SharedPrefManager(this);
        mContext = MainActivity.this;
        mView = drawer_layout;
    }

    public void initNav(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer_layout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
        initPresenter();
        initDataPresenter();
        super.progresDialog();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Carrer_Vacancy) {

        } else if (id == R.id.nav_Upcoming) {

        } else if (id == R.id.nav_News) {

        } else if (id == R.id.nav_Merchants) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void successGetItem(List<NewsItem> NewsItem) {
        MainAdapter Adabter = new MainAdapter(mContext, NewsItem);
        RV_Main.setAdapter(Adabter);

        Snackbar.make(mView, "News up to date.", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();

        progressDialog.dismiss();

        SR_Main.setColorSchemeResources(R.color.colorAccent, R.color.colorAccent2);
        SR_Main.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        initPresenter();
                        initDataPresenter();
                        SR_Main.setRefreshing(false);
                    }
                }, 5000);
            }
        });
    }

    @Override
    public void failedGetItem(String message) {
        Snackbar.make(mView, message, Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        progressDialog.dismiss();
    }
}
