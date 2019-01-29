package com.example.univisiontest.util

import android.app.Activity
import android.content.Intent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ActivityRouter @Inject constructor(var activity: Activity) {

    fun startProductListActivity(category: String) {
        val intent = Intent(activity, ProductListActivity::class.java)
        intent.putExtra("category", category)
        activity.startActivity(intent)
    }

    fun startProductDetailActivity(productId: Long) {
        val intent = Intent(activity, ProductDetailActivity::class.java)
        intent.putExtra(ProductDetailActivity.KEY_PRODUCT_ID, productId)
        activity.startActivity(intent)
    }
}