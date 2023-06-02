package com.hamza.smartx.base

import android.app.Activity
import android.app.Application
import android.graphics.Bitmap
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SmartXApplication: Application(),
    Application.ActivityLifecycleCallbacks,
    LifecycleObserver {

    companion object {
        var appInBackground = false
    }

    override fun onCreate() {
        super.onCreate()

    }


    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {

    }

    override fun onActivityStarted(activity: Activity) {

    }

    override fun onActivityResumed(activity: Activity) {

    }

    override fun onActivityPaused(activity: Activity) {

    }

    override fun onActivityStopped(activity: Activity) {

    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {

    }

    override fun onActivityDestroyed(activity: Activity) {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onAppBackgrounded() {
        appInBackground = true
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onAppForegrounded() {
        appInBackground = false
    }
}