package com.example.android.newsapp;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

/**
 * Loads a list of earthquakes by using an AsyncTask to perform the network request to the given URL
 */
public class ArticleLoader extends AsyncTaskLoader<List<Article>> {

    /** Query URL*/
    private String mUrl;

    /**
     * Constructs a new ArticleLoader
     *
     * @param context of the activity
     * @param url to load data from
     */
    public ArticleLoader(Context context, String url){
        super(context);
        mUrl = url;
    }

    @Override
    protected  void onStartLoading(){
        forceLoad();
    }

    /**
     * This is on a background thread
     */
    @Override
    public List<Article> loadInBackground(){
        if(mUrl == null){
            return null;
        }

        //Perform the network request, parse the response, and extract a list of articles
        List<Article> articles = QueryUtils.fetchArticleData(mUrl);

        return articles;
    }
}
