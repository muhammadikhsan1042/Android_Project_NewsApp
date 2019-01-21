package com.example.newsapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.newsapp.Activity.DetailActivity.DetailActivity;
import com.example.newsapp.Model.NewsItem;
import com.example.newsapp.R;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    Context mContext;
    List<NewsItem> Item;

    public MainAdapter(Context mContext, List<NewsItem> Item){
        this.mContext = mContext;
        this.Item = Item;
    }

    @NonNull
    @Override
    public MainAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // Layout inflater
        View view = LayoutInflater.from(mContext).inflate(R.layout.main_item, viewGroup, false);

        // Hubungkan dengan MyViewHolder
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.MyViewHolder myViewHolder, final int i) {
        myViewHolder.TV_Title.setText(Item.get(i).getTitle());
        myViewHolder.TV_Date.setText(Item.get(i).getCreate_Time());

//        Picasso.with(mContext).load(MyConstant.THUMBNAILS_URL + Item.get(i).getImage()).into(myViewHolder.IV_News);

        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent move = new Intent(mContext, DetailActivity.class);

                move.putExtra("ID", Item.get(i).getID());
                move.putExtra("TITLE", Item.get(i).getTitle());
                move.putExtra("CONTENT", Item.get(i).getMain());
                move.putExtra("DATE", Item.get(i).getCreate_Time());
                move.putExtra("IMAGE", Item.get(i).getImage());

                mContext.startActivity(move);
            }
        });
    }

    @Override
    public int getItemCount() {
        return Item.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
//        ImageView IV_News;
        TextView TV_Title, TV_Date;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
//            IV_News     = itemView.findViewById(R.id.IV_News);
            TV_Title    = itemView.findViewById(R.id.TV_Title);
            TV_Date     = itemView.findViewById(R.id.TV_Date);
        }
    }
}
