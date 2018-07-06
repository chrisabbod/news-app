package com.example.android.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String guardian_request_url = "https://content.guardianapis.com/search?q=politics&api-key=36f66e45-37ec-4793-9f1e-452f9718c623";

    private ArticleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find a reference to the ListView in layout
        ListView newsListView = (ListView)findViewById(R.id.list);

        //Create a new adapter that takes an empty list of news articles as input
        mAdapter = new ArticleAdapter(this, new ArrayList<Article>());

        //Set the adapter on the ListView so the list can be populated in the UI
        newsListView.setAdapter(mAdapter);
    }
}
