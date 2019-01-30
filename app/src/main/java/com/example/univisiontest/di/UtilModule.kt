package com.example.univisiontest.di

import android.content.Context
import com.example.univisiontest.util.ToastUtil
import com.example.univisiontest.util.Utils
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilModule {


    @Provides
    @Singleton
    internal fun providesUtils(): Utils {
        return Utils()
    }

    @Provides
    @Singleton
    internal fun providesToastUtil(@AppContext context: Context): ToastUtil {
        return ToastUtil(context)
    }


}