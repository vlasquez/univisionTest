package com.example.univisiontest.di

import android.app.Activity
import com.example.univisiontest.App
import com.example.univisiontest.ui.createarticle.CreateArticleActivity
import com.example.univisiontest.ui.main.ArticlesActivity
import com.example.univisiontest.ui.searcharticle.SearchArticleActivity
import dagger.Subcomponent

@PerActivity
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

    fun inject(activity: ArticlesActivity)
    fun inject(activity: CreateArticleActivity)
    fun inject(activity: SearchArticleActivity)

    companion object {
        fun component(activity: Activity): ActivityComponent {
            return App.component(activity)!!.plusActivityModule(ActivityModule(activity))
        }
    }

}