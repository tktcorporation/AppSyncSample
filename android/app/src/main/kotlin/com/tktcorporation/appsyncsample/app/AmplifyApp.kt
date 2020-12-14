package com.tktcorporation.appsyncsample.app

import android.app.Application
import android.util.Log
import com.amplifyframework.AmplifyException

import com.amplifyframework.core.Amplify

class AmplifyApp : Application() {
  override fun onCreate() {
    super.onCreate()
    try {
      Amplify.configure(applicationContext)
      Log.i("MyAmplifyApp", "Initialized Amplify")
    } catch (e: AmplifyException) {
      Log.e("MyAmplifyApp", "Could not initialize Amplify", e)
    }
  }
}
