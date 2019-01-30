package com.example.univisiontest.repos;

import com.example.univisiontest.data.local.RealmDB;
import com.example.univisiontest.model.Article;
import io.realm.RealmResults;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ArticlesRepository {

    private RealmDB db;

    @Inject
    public ArticlesRepository(RealmDB db) {
        this.db = db;
    }

    public void addArticle(Article article) {
        db.addArticle(article);
    }

    public RealmResults<Article> getArticles(String cityId) {
        return db.getArticleByCityId(cityId);
    }
}