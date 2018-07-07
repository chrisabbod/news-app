package com.example.android.newsapp;

public class Article {
    private String mTitle, mSection;
    private String mAuthorFirstName, mAuthorMiddleName, mAuthorLastName;
    private String mDate;
    private String mUrl;

    /** Website URL with Guardian Article Data */
    private String mApiUrl;

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

    public String getAuthorFirstName() {
        return mAuthorFirstName;
    }

    public void setAuthorFirstName(String mAuthorFirstName) {
        this.mAuthorFirstName = mAuthorFirstName;
    }

    public String getAuthorMiddleName() {
        return mAuthorMiddleName;
    }

    public void setAuthorMiddleName(String mAuthorMiddleName) {
        this.mAuthorMiddleName = mAuthorMiddleName;
    }

    public String getAuthorLastName() {
        return mAuthorLastName;
    }

    public void setAuthorLastName(String mAuthorLastName) {
        this.mAuthorLastName = mAuthorLastName;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String mDate) {
        this.mDate = mDate;
    }

    //Extracts author name from given string
    public String parseAuthorName(String string){
        String newString = string.substring(string.indexOf("|") + 1, string.length());

        return newString;
    }

    //Extracts date from given string
    public String parseDate(String string){
        String newString = string.substring(0, string.indexOf("T"));

        return newString;
    }
}
