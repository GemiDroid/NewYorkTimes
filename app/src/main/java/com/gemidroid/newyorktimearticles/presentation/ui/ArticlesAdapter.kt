package com.gemidroid.newyorktimearticles.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.gemidroid.newyorktimearticles.R
import com.gemidroid.newyorktimearticles.data.model.Articles
import kotlinx.android.synthetic.main.article_list_item.view.*

class ArticlesAdapter(private var articles: List<Articles>,
                      private val onArticleClickListener: (Articles) -> (Unit))
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun updateArticleList(mArticlesList: List<Articles>) {
        articles = mArticlesList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.article_list_item, parent, false)
        return object : RecyclerView.ViewHolder(view) {}
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val article = articles[position]
        bind(holder, article)
        holder.itemView.setOnClickListener {
            onArticleClickListener.invoke(article)
        }
    }

    private fun bind(holder: RecyclerView.ViewHolder, article: Articles) {

        holder.itemView.apply {
            tv_article_title.text = article.title
            tv_article_description.text = article.description
            tv_date.text = article.publishDate
            Glide.with(holder.itemView)
                    .load(if (article.media!!.isEmpty()) R.drawable.ic_launcher_foreground else article.media[0].metaDataList!![0].imgUrl)
                    .error(R.drawable.ic_launcher_foreground)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .into(iv_article)
        }
    }

    override fun getItemCount(): Int {
        return articles.size
    }
}