package com.example.android.newsapp;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static com.example.android.newsapp.MainActivity.LOG_TAG;

/**
 * Helper methods for requesting/receiving data from The Guardian
 */
public final class QueryUtils {

    /**
     * Create a private constructor because no one will ever need to create an object.
     * This class is only meant to hold static variables and methods, which can be accessed
     * directly fro the class name QueryUtils
     */
    private QueryUtils(){
        //No need to ever create an object
    }

    private static List<Article> extractFeaturesFromJson(String articleJSON){
        //If Json string is null or empty return early
        if(TextUtils.isEmpty(articleJSON)){
            return null;
        }

        //Create an empty array list to add Article articles to
        List<Article> articles = new ArrayList<>();

        //Try to parse the JSON response string. If there's a problem with the way the JSON is
        //formatted, a JSONException exception object will be thrown.
        //Catch the exception so the app doesn't crash, and print the error message to the logs.
        try{

            //Create a JSONObject from the JSON response string
            JSONObject baseJsonResponse = new JSONObject(articleJSON);

            //Extract the JSONArray associated with the key called "results",
            //which represents a list of results (or articles articles).
            JSONArray articleArray = baseJsonResponse.getJSONArray("response");

            //For each articles article in the newsArray, create a articles object
            for (int i = 0; i < articleArray.length(); i++){
                //Get a single article at position i within the list of articles articles
                JSONObject currentArticle = articleArray.getJSONObject(i);

                //For a given article, extract the JSONObject associated with the key called
                //"results", which represents a list of all properties for that article
                JSONObject results = currentArticle.getJSONObject("results");

                //Extract the value for the key called "webTitle"
                String title = results.getString("webTitle");

                //Extract the value for the key called "sectionName"
                String section = results.getString("sectionName");

                //Extract the value for the key called "webPublicationDate"
                long date = results.getLong("webPublicationDate");

                //Extract the value for the key called "webUrl"
                String url = results.getString("webUrl");

                //TODO: Add Author

                //Create a new Article object with the title, section, date, and author
                //then add to the JSON response
                Article article = new Article(title, section);

                //Add the new Article to the list of articles
                articles.add(article);
            }
        }catch(JSONException e){
            //If an error is thrown when executing any of the above statements in the "try" block,
            //catch the exception here, so the app doesn't crash. Print a log message
            //with the message from the exception.
            Log.e("QueryUtils", "Problem parsing the articles JSON results", e);
        }

        //Return the list of articles articles
        return articles;
    }

    /**
     * Make an HTTP request to the given URL and return a String response
     */
    private static URL createURL(String stringURL){
        URL url = null;
        try{
            url = new URL(stringURL);
        }catch(MalformedURLException e){
            Log.e(LOG_TAG, "Problem building the URL ", e);
        }
        return url;
    }

    /**
     * Convert the InputStream into a String which contains the whole JSON response from the server
     */
    private static String readFromStream(InputStream inputStream) throws IOException {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            while (line != null) {
                output.append(line);
                line = reader.readLine();
            }
        }
        return output.toString();
    }

}
