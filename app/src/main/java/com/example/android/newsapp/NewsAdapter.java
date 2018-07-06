package com.example.android.newsapp;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {

    public NewsAdapter(Context context, List<News> news){
        super(context, 0, news);
    }
}
