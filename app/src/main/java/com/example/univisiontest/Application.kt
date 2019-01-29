package com.example.univisiontest

import android.content.Context
import android.util.Log
import androidx.multidex.MultiDexApplication
import com.example.univisiontest.di.AppComponent
import com.example.univisiontest.util.Foreground
import io.realm.Realm
import java.io.IOException

class App : MultiDexApplication() {

    private var appComponent: AppComponent? = null


    override fun onCreate() {
        super.onCreate()

        Realm.init(this)

        appComponent = AppComponent.component(this)
        appComponent!!.inject(this)

        initForeground()
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
        fun component(context: Context): AppComponent? {
            return (context.applicationContext as App).appComponent
        }
    }

}