package com.example.univisiontest.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Singleton
@Module(includes = [PersistenceModule::class, UtilModule::class])
class AppModule(app: Application) {

    private val app: Application = app


    @Provides
    @Singleton
    internal fun providesApplication(): Application {
        return app
    }

    @Provides
    @Singleton
    @AppContext
    internal fun providesContext(): Context {
        return app
    }

}