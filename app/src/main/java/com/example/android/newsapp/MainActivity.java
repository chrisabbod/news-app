package com.example.android.newsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String guardian_request_url = "https://content.guardianapis.com/search?q=politics&api-key=36f66e45-37ec-4793-9f1e-452f9718c623";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
