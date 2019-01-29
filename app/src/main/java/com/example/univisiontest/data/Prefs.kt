package com.example.univisiontest.data

import android.content.Context
import android.content.SharedPreferences
import com.example.univisiontest.BuildConfig
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Prefs @Inject
constructor(private val context: Context) {
    private val sharedPreferences: SharedPreferences

    var userID: Int
        get() = sharedPreferences.getInt("userid", 0)
        set(userid) = sharedPreferences.edit().putInt("userid", userid).apply()

    init {
        val KEY_PREFERENCE_NAME = BuildConfig.APPLICATION_ID + ".PREFERENCE_FILE_KEY"
        sharedPreferences = context.getSharedPreferences(KEY_PREFERENCE_NAME, Context.MODE_PRIVATE)
    }

    fun clearPreferences() {
        sharedPreferences.edit().clear().apply()
    }
}
