package com.example.univisiontest.util

import android.app.Activity
import android.content.Intent
import com.example.univisiontest.ui.createarticle.CreateArticleActivity
import com.example.univisiontest.ui.main.ArticlesActivity
import com.example.univisiontest.ui.searcharticle.SearchArticleActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ActivityRouter @Inject constructor(var activity: Activity) {
    fun startArticlesActivity() {
        val intent = Intent(activity, ArticlesActivity::class.java)
        activity.startActivity(intent)
    }

    fun startCreateArticleActivity() {
        val intent = Intent(activity, CreateArticleActivity::class.java)
        activity.startActivity(intent)
    }

    fun startSearchArticleActivity() {
        val intent = Intent(activity, SearchArticleActivity::class.java)
        activity.startActivity(intent)
    }
}