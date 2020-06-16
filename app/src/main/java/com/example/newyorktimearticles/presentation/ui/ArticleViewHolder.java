package com.example.newyorktimearticles.presentation.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newyorktimearticles.R;

class ArticleViewHolder extends RecyclerView.ViewHolder {
    TextView articleTitle;
    TextView articleDetails;
    ImageView articleImg;
    TextView articleDate;

    public ArticleViewHolder(@NonNull View itemView) {
        super(itemView);
        articleTitle = itemView.findViewById(R.id.tvArticleTitle);
        articleDetails = itemView.findViewById(R.id.tvArticleDescription);
        articleDate = itemView.findViewById(R.id.tvDate);
        articleImg = itemView.findViewById(R.id.ivArticle);
    }
}
