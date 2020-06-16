package com.example.newyorktimearticles.presentation.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.newyorktimearticles.R;
import com.example.newyorktimearticles.data.model.Articles;

import java.util.List;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticleViewHolder> {

    private List<Articles> articles;
    private OnArticleClickListener onArticleClickListener;

    public ArticlesAdapter(OnArticleClickListener onArticleClickListener, List<Articles> articles) {
        this.onArticleClickListener = onArticleClickListener;
        this.articles = articles;
    }

    public void updateArticleList(List<Articles> mArticlesList) {
        this.articles = mArticlesList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.article_list_item, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        Articles article = bind(holder, position);
        holder.itemView.setOnClickListener(view -> onArticleClickListener.onArticleClick(article));
    }

    private Articles bind(@NonNull ArticleViewHolder holder, int position) {
        Articles article = articles.get(position);
        holder.articleTitle.setText(article.getTitle());
        holder.articleDetails.setText(article.getDescription());
        holder.articleDate.setText(article.getPublishDate());
        Glide.with(holder.itemView)
                .load(article.getMedia().isEmpty() ? R.drawable.ic_launcher_foreground :
                        article.getMedia().get(0).getMetaDataList().get(0).getImgUrl())
                .error(R.drawable.ic_launcher_foreground)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(holder.articleImg);
        return article;
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
}
