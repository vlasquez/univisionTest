package com.example.univisiontest.di

import android.app.Application
import com.example.univisiontest.App
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    fun inject(app: App)

    fun plusActivityModule(activityModule: ActivityModule): ActivityComponent


    companion object {
        fun component(application: Application): AppComponent {
            return DaggerAppComponent.builder().appModule(AppModule(application)).persistenceModule(PersistenceModule())
                .build()
        }
    }


}