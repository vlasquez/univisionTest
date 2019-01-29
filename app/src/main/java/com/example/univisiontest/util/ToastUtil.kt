package com.example.univisiontest.util

import android.content.Context
import android.view.Gravity
import android.widget.Toast
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ToastUtil @Inject
constructor(private val context: Context) {

    fun showLongMessage(msg: String) {
        val toast = Toast.makeText(context, msg, Toast.LENGTH_LONG)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }

    fun showShortMessage(msg: String) {
        val toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }


}