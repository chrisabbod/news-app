package com.example.android.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ArticleAdapter extends ArrayAdapter<Article> {

    public ArticleAdapter(Context context, List<Article> articles){
        super(context, 0, articles);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //Check if there is an existing view to reuse
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.news_list_item, parent, false);
        }

        //Find the article at the given position in the list of news items
        Article currentArticle = getItem(position);

        TextView titleView = (TextView)listItemView.findViewById(R.id.title);
        TextView sectionView = (TextView)listItemView.findViewById(R.id.section);
        TextView contributorOneView = (TextView)listItemView.findViewById(R.id.contributor_one);
        TextView contributorTwoView = (TextView)listItemView.findViewById(R.id.contributor_two);
        TextView dateView = (TextView)listItemView.findViewById(R.id.date);

        titleView.setText(currentArticle.getTitle());
        sectionView.setText(currentArticle.getSection());

        ArrayList<String> contributorList = currentArticle.getContributors();

        contributorOneView.setText(contributorList.get(0));

        if(contributorList.size() > 1){
            contributorTwoView.setText(contributorList.get(1));
        }

        dateView.setText(currentArticle.parseDate(currentArticle.getDate()));

        return listItemView;
    }
}
