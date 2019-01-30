package com.example.univisiontest

import android.content.Context
import android.util.Log
import androidx.multidex.MultiDexApplication
import com.example.univisiontest.di.AppComponent
import com.example.univisiontest.util.Foreground
import com.facebook.stetho.Stetho
import com.uphyca.stetho_realm.RealmInspectorModulesProvider
import io.realm.Realm
import java.io.IOException

class App : MultiDexApplication() {

    private lateinit var appComponent: AppComponent


    override fun onCreate() {
        super.onCreate()

        Realm.init(this)

        appComponent = AppComponent.component(this)
        appComponent.inject(this)

        initForeground()
        Stetho.initialize(
            Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                .build())
    }


    fun initForeground() {
        Foreground.init(this).addListener(object : Foreground.Listener {
            override fun onBecameForeground() {
                Log.e("Event", "onBecameForeground")
            }

            @Throws(IOException::class)
            override fun onBecameBackground() {
                Log.e("Event", "onBecameBackground")
            }
        })
    }

    companion object {
        fun component(context: Context): AppComponent {
            return (context.applicationContext as App).appComponent
        }
    }

}