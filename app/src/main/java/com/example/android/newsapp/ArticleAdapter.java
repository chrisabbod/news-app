package com.example.android.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

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
        TextView authorView = (TextView)listItemView.findViewById(R.id.author);
        TextView dateView = (TextView)listItemView.findViewById(R.id.date);

        titleView.setText(currentArticle.getTitle());
        sectionView.setText(currentArticle.getSection());

        if(currentArticle.getTitle().contains("|")){
            currentArticle.parseAuthorName(currentArticle.getTitle());
            authorView.setText(currentArticle.getAuthorName());
        }

        dateView.setText(currentArticle.parseDate(currentArticle.getDate()));

        return listItemView;
    }
}
