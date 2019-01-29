package com.example.univisiontest.util

import android.app.Activity
import android.content.Intent
import com.example.univisiontest.ui.main.ArticlesActivity
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ActivityRouter @Inject constructor(var activity: Activity) {

    fun startCreateArticleActivity() {
        val intent = Intent(activity, ProductListActivity::class.java)
        intent.putExtra("category", category)
        activity.startActivity(intent)
    }

    fun startSearchArticleActivity() {
        val intent = Intent(activity, ProductDetailActivity::class.java)

        activity.startActivity(intent)
    }

    fun startArticlesActivity() {
        val intent = Intent(activity, ArticlesActivity::class.java)
        activity.startActivity(intent)
    }
}