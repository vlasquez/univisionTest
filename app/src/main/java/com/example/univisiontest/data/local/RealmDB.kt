package com.example.univisiontest.data.local

import com.example.univisiontest.model.Article
import io.realm.Realm
import io.realm.RealmResults

class RealmDB(realm: Realm) {
    private var realm = realm

    fun saveArticles(articles: List<Article>) {
        realm.executeTransactionAsync { realm -> realm.copyToRealmOrUpdate(articles) }
    }

    fun getArticleById(id: Long): RealmResults<Article> {
        return realm.where(Article::class.java!!).equalTo("id", id).findAllAsync()
    }

    fun getArticleByCityId(cityId: String): RealmResults<Article> {
        return realm.where(Article::class.java).equalTo("cityId", cityId).findAllAsync()
    }

    fun addArticle(article: Article) {
        realm.executeTransaction { realm ->

            val currentIdNum = realm.where(article::class.java).max("id")
            val nextId: Long
            if (currentIdNum == null) {
                nextId = 1
            } else {
                nextId = currentIdNum.toLong() + 1
            }
            val article = Article()
            article.id = nextId
            article.cityId = article.cityId
            article.author = article.author
            article.content = article.content
            realm.insertOrUpdate(article)
        }
    }
}