package com.example.newyorktimearticles.presentation.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.newyorktimearticles.R;
import com.example.newyorktimearticles.data.model.Articles;

public class ArticleDetailFragment extends Fragment {

    Articles selectedArticle;
    ImageView imgArticle;
    TextView tvArticleDetails;

    public static ArticleDetailFragment newInstance(Articles mArticle) {
        Bundle args = new Bundle();
        args.putSerializable(ArticleListActivity.ARTICLE_KEY, mArticle);
        ArticleDetailFragment fragment = new ArticleDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        assert getArguments() != null;
        selectedArticle = (Articles) getArguments().get(ArticleListActivity.ARTICLE_KEY);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_article_detail, container, false);
        setUpToolBar(rootView);
        initViews(rootView);
        Glide.with(rootView)
                .load(selectedArticle.getMedia().isEmpty() ? R.drawable.ic_launcher_foreground :
                        selectedArticle.getMedia().get(0).getMetaDataList().get(0).getImgUrl())
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .into(imgArticle);
        tvArticleDetails.setText(selectedArticle.getDescription());

        return rootView;
    }

    private void setUpToolBar(View rootView) {
        Toolbar toolbar = rootView.findViewById(R.id.detail_toolbar);
        AppCompatActivity context = ((AppCompatActivity) requireActivity());
        context.setSupportActionBar(toolbar);
        ActionBar actionBar = context.getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(selectedArticle.getTitle());
        }
    }

    private void initViews(View rootView) {
        imgArticle = rootView.findViewById(R.id.ivArticleDetails);
        tvArticleDetails = rootView.findViewById(R.id.tvArticleDetails);
    }
}