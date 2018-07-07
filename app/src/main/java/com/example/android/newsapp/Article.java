package com.example.android.newsapp;

public class Article {
    private String mTitle, mSection;
    private String mAuthorName;
    private String mDate;
    private String mUrl;

    public Article(String mTitle, String mSection, String mDate, String mUrl) {
        this.mTitle = mTitle;
        this.mSection = mSection;
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

    public String getAuthorName() {
        return mAuthorName;
    }

    public void setAuthorName(String mAuthorName) {
        this.mAuthorName = mAuthorName;
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

    //Extracts author name from given string
    public void parseAuthorName(String string){
        String newString = string.substring(string.indexOf("|") + 1, string.length());

        setAuthorName(newString);
    }

    //Extracts date from given string
    public String parseDate(String string){
        String newString = string.substring(0, string.indexOf("T"));

        return newString;
    }
}
