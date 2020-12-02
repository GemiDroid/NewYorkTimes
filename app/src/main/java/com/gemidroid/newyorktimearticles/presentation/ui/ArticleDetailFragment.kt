package com.gemidroid.newyorktimearticles.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.gemidroid.newyorktimearticles.R
import com.gemidroid.newyorktimearticles.data.model.Articles
import com.gemidroid.newyorktimearticles.utility.Constants.ARTICLE_KEY
import kotlinx.android.synthetic.main.article_details_content.*
import kotlinx.android.synthetic.main.fragment_article_detail.*

class ArticleDetailFragment : Fragment() {
    var selectedArticle: Articles? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_article_detail, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireActivity().intent.extras?.getSerializable(ARTICLE_KEY).let {
            it as Articles
            selectedArticle = it
        }

        setUpToolBar()

        Glide.with(this)
            .load(if (selectedArticle?.media!!.isEmpty()) R.drawable.ic_launcher_foreground else selectedArticle?.media!![0].metaDataList!![0].imgUrl)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .into(iv_article_details)
        tv_article_details.text = selectedArticle?.description
    }

    private fun setUpToolBar() {
        val context = requireActivity() as AppCompatActivity
        context.setSupportActionBar(detail_toolbar)
        val actionBar = context.supportActionBar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
            actionBar.title = selectedArticle?.title
        }
    }

}