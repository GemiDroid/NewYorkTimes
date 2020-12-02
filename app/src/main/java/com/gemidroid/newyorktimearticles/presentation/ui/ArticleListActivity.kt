package com.gemidroid.newyorktimearticles.presentation.ui

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import com.gemidroid.newyorktimearticles.R
import com.gemidroid.newyorktimearticles.presentation.viewmodel.ArticleListViewModel
import com.gemidroid.newyorktimearticles.utility.Constants.ARTICLE_KEY
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_article_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.net.UnknownHostException
import java.util.*

class ArticleListActivity : AppCompatActivity() {

    private val articleListViewModel by viewModel<ArticleListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article_list)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val mDrawerLayout = findViewById<DrawerLayout>(R.id.drawer)
        val mDrawerToggle = ActionBarDrawerToggle(this, mDrawerLayout, toolbar, 0, 0)
        mDrawerLayout.addDrawerListener(mDrawerToggle)
        mDrawerToggle.syncState()

        getArticlesList()
        displayError()
    }


    private fun getArticlesList() {
        articleListViewModel.observeOnArticleList.observe(this, {
            progress.visibility = View.GONE
            rec_articles.apply {
                adapter = ArticlesAdapter(it) {
                    val destination =
                        Intent(this@ArticleListActivity, ArticleDetailActivity::class.java)
                    destination.putExtra(ARTICLE_KEY, it)
                    startActivity(destination)
                }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.article_list_menu, menu)
        return true
    }

    private fun displayError() {
        articleListViewModel.observeOnError.observe(this, {
            progress.visibility = View.GONE
            val errorMessage: String = when (it) {
                is UnknownHostException -> getString(R.string.no_internet_connection)
                else -> getString(R.string.unknown_error)
            }
            Snackbar.make(progress!!.rootView, errorMessage, Snackbar.LENGTH_SHORT).show()

        })
    }
}