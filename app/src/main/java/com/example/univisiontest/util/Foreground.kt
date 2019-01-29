package com.example.univisiontest.util

import android.app.Activity
import android.app.Application
import android.content.Context
import android.os.Bundle
import android.os.Handler
import java.io.IOException
import java.util.concurrent.CopyOnWriteArrayList

class Foreground : Application.ActivityLifecycleCallbacks {

    val CHECK_DELAY: Long = 500

    var isForeground = false
        private set
    private var paused = true
    private val handler = Handler()
    private val listeners = CopyOnWriteArrayList<Listener>()
    private var check: Runnable? = null
    val isBackground: Boolean
        get() = !isForeground


    interface Listener {
        fun onBecameForeground()

        @Throws(IOException::class)
        fun onBecameBackground()
    }

    fun addListener(listener: Listener) {
        listeners.add(listener)
    }

    fun removeListener(listener: Listener) {
        listeners.remove(listener)
    }

    override fun onActivityResumed(activity: Activity) {
        paused = false
        val wasBackground = !isForeground
        isForeground = true

        if (check != null) handler.removeCallbacks(check)
        if (wasBackground) {
            for (l in listeners) {
                try {
                    l.onBecameForeground()
                } catch (exc: Exception) {
                }

            }
        }
    }

    override fun onActivityPaused(activity: Activity) {
        paused = true

        if (check != null)
            handler.removeCallbacks(check)

        handler.postDelayed({
            if (isForeground && paused) {
                isForeground = false
                for (l in listeners) {
                    try {
                        l.onBecameBackground()
                    } catch (exc: Exception) {
                    }

                }
            }
        }, CHECK_DELAY)
    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle) {}

    override fun onActivityStarted(activity: Activity) {}

    override fun onActivityStopped(activity: Activity) {}

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}

    override fun onActivityDestroyed(activity: Activity) {}

    companion object {

        private var instance: Foreground? = null


        fun init(application: Application): Foreground {
            if (instance == null) {
                instance = Foreground()
                application.registerActivityLifecycleCallbacks(instance)
            }
            return instance!!
        }

        operator fun get(application: Application): Foreground? {
            if (instance == null) init(application)
            return instance
        }

        operator fun get(ctx: Context): Foreground {
            if (instance == null) {
                val appCtx = ctx.applicationContext
                if (appCtx is Application) {
                    init(appCtx)
                }
                throw IllegalStateException(
                    "Foreground is not initialised and " + "cannot obtain the Application object"
                )
            }
            return instance!!
        }

        fun get(): Foreground {
            if (instance == null) {
                throw IllegalStateException(
                    "Foreground is not initialised - invoke " + "at least once with parameterised init/get"
                )
            }
            return instance!!
        }
    }
}

