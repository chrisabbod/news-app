package com.example.android.newsapp;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<Article>> {

    private static final String GUARDIAN_REQUEST_URL = "https://content.guardianapis.com/search?api-key=36f66e45-37ec-4793-9f1e-452f9718c623";
    public static final String LOG_TAG = MainActivity.class.getName();

    /**
     * Constant value for the earthquake loader ID. We can choose any integer.
     * This really only comes into play if you're using multiple loaders.
     */
    private static final int ARTICLE_LOADER_ID = 1;

    private ArticleAdapter mAdapter;

    /** TextView that is displayed when the list is empty*/
    private TextView mEmptyStateTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find a reference to the ListView in layout
        ListView articleListView = (ListView)findViewById(R.id.list);

        //Create a new adapter that takes an empty list of news articles as input
        mAdapter = new ArticleAdapter(this, new ArrayList<Article>());

        mEmptyStateTextView = (TextView)findViewById(R.id.empty_view);
        articleListView.setEmptyView(mEmptyStateTextView);

        //Set the adapter on the ListView so the list can be populated in the UI
        articleListView.setAdapter(mAdapter);

        //Set onClickListener
        articleListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Article currentArticle = mAdapter.getItem(i);

                //Convert the String URL into a URI object to pass into the Intent Constructor
                Uri articleUri = Uri.parse(currentArticle.getUrl());

                //Create a new intent to view the article Uri
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW, articleUri);
                startActivity(websiteIntent);
            }
        });

        //Get a reference to the ConnectivityManager to check state of network connectivity
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        //Get details on currently active default data network
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        //If there is a network connection, fetch data
        if(networkInfo != null && networkInfo.isConnected()){
            //Get a reference to the LoaderManager, in order to interact with loaders.
            LoaderManager loaderManager = getLoaderManager();

            // Initialize the loader. Pass in the int ID constant defined above and pass in null for
            // the bundle. Pass in this activity for the LoaderCallbacks parameter (which is valid
            // because this activity implements the LoaderCallbacks interface).
            loaderManager.initLoader(ARTICLE_LOADER_ID, null, this);
        }else{
            //Display Error
            //First hide loading indicator so error message will be visable
            View loadingIndicator = findViewById(R.id.loading_indicator);
            loadingIndicator.setVisibility(View.GONE);

            //Update empty state with no connection error message
            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }
    }

    @Override
    public Loader<List<Article>> onCreateLoader(int i, Bundle bundle){
        //Create a new loader for the given URL
        return new ArticleLoader(this, GUARDIAN_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<Article>> loader, List<Article> articles){
        //Hide loading indicator because the data has been loaded
        View loadingIndicator = findViewById(R.id.loading_indicator);
        loadingIndicator.setVisibility(View.GONE);

        //Clear the adapter of previous article data
        mAdapter.clear();

        //If there is a valid list of articles then add them to the adapter's data set.
        //This will trigger the ListView to update.
        if(articles != null && !articles.isEmpty()){
            mAdapter.addAll(articles);
        }
    }

    @Override
    public void onLoaderReset(Loader<List<Article>> loader){
        //Loader reset, so we can clear out our existing data.
        mAdapter.clear();
    }
}
