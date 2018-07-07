package com.example.android.newsapp;

public class Article {
    private String mTitle, mSection;
    private String mAuthorFirstName, mAuthorMiddleName, mAuthorLastName;
    private String mDate;
    private String mUrl;

    /** Website URL with Guardian Article Data */
    private String mApiUrl;

    public Article(String mTitle, String mSection) {
        this.mTitle = mTitle;
        this.mSection = mSection;
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
}
