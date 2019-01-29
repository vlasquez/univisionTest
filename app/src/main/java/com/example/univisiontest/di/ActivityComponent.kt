package com.example.univisiontest.di
import android.app.Activity
import com.example.univisiontest.App
import dagger.Subcomponent

@PerActivity
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {
    abstract fun inject(activity: MainActivity)
    abstract fun inject(activity: ProductListActivity)
    abstract fun inject(activity: ProductDetailActivity)


    fun component(activity: Activity): ActivityComponent {
        return App.component(activity).plusActivityModule(ActivityModule(activity))
    }
}