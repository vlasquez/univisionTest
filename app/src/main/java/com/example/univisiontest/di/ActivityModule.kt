package com.example.univisiontest.di

import android.app.Activity
import android.content.Context
import com.example.univisiontest.util.ActivityRouter
import dagger.Module
import dagger.Provides


@PerActivity
@Module
class ActivityModule(activity: Activity) {
    private var activity: Activity = activity

    @Provides
    @ActivityContext
    fun provideContext(): Context {
        return activity
    }

    @Provides
    fun provideActivity(): Activity {
        return activity
    }

    @Provides
    fun providesActivityRouter(): ActivityRouter {
        return ActivityRouter(activity)
    }
}