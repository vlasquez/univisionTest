package com.example.univisiontest.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.OnClick
import com.example.univisiontest.R
import com.example.univisiontest.R.id
import com.example.univisiontest.R.layout
import com.example.univisiontest.di.ActivityComponent
import com.example.univisiontest.util.ActivityRouter
import kotlinx.android.synthetic.main.articles_activity.*
import javax.inject.Inject

class ArticlesActivity : AppCompatActivity() {

    @Inject
    lateinit var router: ActivityRouter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.articles_activity)
        setSupportActionBar(toolbar)
        ButterKnife.bind(this)
        ActivityComponent.component(this).inject(this)
    }

    @OnClick(R.id.create_art_btn)
    fun onClickCreateArticle() {
        router.startCreateArticleActivity()
    }
    @OnClick(R.id.search_art_btn)
    fun onClickSearchArticle(){
        router.startSearchArticleActivity()
    }

}
