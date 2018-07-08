package com.example.android.newsapp;

import java.util.ArrayList;

public class Article {
    private String mTitle, mSection;
    private ArrayList<String> mContributors = new ArrayList<String>();
    private String mDate;
    private String mUrl;

    public Article(String mTitle, String mSection, String mDate, String mUrl) {
        this.mTitle = mTitle;
        this.mSection = mSection;
        this.mContributors = mContributors;
        this.mDate = mDate;
        this.mUrl = mUrl;
    }

    //Overloaded constructor
    public Article(String mTitle, String mSection, ArrayList<String> mContributors, String mDate, String mUrl) {
        this.mTitle = mTitle;
        this.mSection = mSection;
        this.mContributors = mContributors;
        this.mDate = mDate;
        this.mUrl = mUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getSection() {
        return mSection;
    }

    public void setSection(String mSection) {
        this.mSection = mSection;
    }

    public ArrayList<String> getContributors() {
        return mContributors;
    }

    public void setContributors(ArrayList<String> mContributors) {
        this.mContributors = mContributors;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String mDate) {
        this.mDate = mDate;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String mUrl) {
        this.mUrl = mUrl;
    }

    //Extracts date from given string
    public String parseDate(String string){
        String newString = string.substring(0, string.indexOf("T"));

        return newString;
    }
}
