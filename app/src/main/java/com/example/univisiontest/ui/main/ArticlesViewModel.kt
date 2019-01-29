package com.example.univisiontest.ui.main

import androidx.lifecycle.ViewModel
import com.example.univisiontest.model.Article

class ArticlesViewModel : ViewModel() {
    private var article: Article? = null

    fun getArticle(): Article? {
        return article
    }

    fun setArticle(article: Article) {
        this.article = article
    }
}
