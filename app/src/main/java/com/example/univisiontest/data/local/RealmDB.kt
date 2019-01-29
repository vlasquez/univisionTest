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
        return realm.where(Article::class.java!!).equalTo("id", cityId).findAllAsync()
    }

    fun addArticle(article: Article) {
        realm.executeTransactionAsync { realm ->
            realm.copyToRealmOrUpdate(article)
        }
    }
}