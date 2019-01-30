package com.example.univisiontest.di

import android.content.Context
import com.example.univisiontest.data.Prefs
import com.example.univisiontest.data.local.RealmDB
import dagger.Module
import dagger.Provides
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Singleton


@Module
class PersistenceModule {

    @Provides
    @Singleton
    fun providesPrefs(@AppContext context: Context): Prefs {
        return Prefs(context)
    }

    @Provides
    fun providesLocalRealmDB(realm: Realm): RealmDB {
        return RealmDB(realm)
    }

    @Provides
    fun providesRealm(realmConfiguration: RealmConfiguration): Realm {
        return Realm.getInstance(realmConfiguration)
    }

    @Provides
    @Singleton
    fun providesRealmConfiguration(): RealmConfiguration {
        val builder = RealmConfiguration.Builder()
        builder.deleteRealmIfMigrationNeeded()
        // builder.inMemory();
        return builder.build()
    }
}