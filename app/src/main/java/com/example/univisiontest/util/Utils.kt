package com.example.univisiontest.util

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.TextUtils
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import android.util.TypedValue
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import com.example.univisiontest.R
import java.util.*
import javax.inject.Singleton

@Singleton
class Utils {


    fun showKeyboard(context: Context, view: View) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(view, 0)
    }

    fun hideKeyboard(context: Context, view: View) {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun degreeToRadians(deg: Double): Double {
        return deg * (Math.PI / 180)
    }

    fun showProgressDialog(context: Context, title: String, body: String, isCancellable: Boolean) {
        showProgressDialog(context, title, body, null, isCancellable)
    }

    fun showProgressDialog(context: Context, title: String, body: String, icon: Drawable?, isCancellable: Boolean) {

        if (context is Activity) {
            if (!context.isFinishing) {
                mProgressDialog = ProgressDialog.show(context, title, body, true)
                mProgressDialog!!.setIcon(icon)
                mProgressDialog!!.setCancelable(isCancellable)
            }
        }
    }


    fun getDip(context: Context, px: Int): Int {
        val scale = context.resources.displayMetrics.density
        return (px * scale + 0.5f).toInt()
    }

    fun getPx(context: Context, dp: Int): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), context.resources.displayMetrics)
            .toInt()
    }

    fun getAppVersionCode(context: Context): Int {
        var v = 0
        try {
            v = context.packageManager.getPackageInfo(context.packageName, 0).versionCode
        } catch (e: PackageManager.NameNotFoundException) {
        }

        return v
    }

    companion object {


        internal var mProgressDialog: ProgressDialog? = null

        fun getAppName(context: Context): String {
            return context.resources.getString(R.string.app_name)
        }

        fun isEmptyOrNull(text: String?): Boolean {
            return text == null || TextUtils.isEmpty(text) || text.isEmpty()
        }

        fun notNullStr(text: String?): String {
            return text ?: ""
        }

        fun geOffsetFromUtc(): Int {
            return TimeZone.getDefault().getOffset(Date().time) / 1000
        }


        fun tryParseInt(text: String): Int {
            try {
                return Integer.parseInt(text)
            } catch (e: Exception) {
                return 0
            }

        }

        fun tryParseLong(text: String): Long {
            try {
                return java.lang.Long.parseLong(text)

            } catch (e: Exception) {
                return 0L
            }

        }

        fun tryParseFloat(text: String): Float {
            try {
                return java.lang.Float.parseFloat(text)

            } catch (e: Exception) {
                return 0f
            }

        }

        fun tryParseDouble(text: String): Double {
            try {
                return java.lang.Double.parseDouble(text)

            } catch (e: Exception) {
                return 0.0
            }

        }

        fun openSoftKeyboard(context: Context, etText: EditText) {
            etText.post {
                etText.requestFocus()
                val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.showSoftInput(etText, InputMethodManager.SHOW_IMPLICIT)
            }
        }


        fun appendBoldOnly(span: SpannableStringBuilder, text: String) {
            span.append(text)
            span.setSpan(
                StyleSpan(Typeface.BOLD),
                span.length - text.length,
                span.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }

        fun appendBold(span: SpannableStringBuilder, text: String) {
            span.append(text)
            span.setSpan(
                StyleSpan(Typeface.BOLD),
                span.length - text.length,
                span.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
            span.setSpan(
                ForegroundColorSpan(Color.DKGRAY),
                span.length - text.length,
                span.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
    }


}
