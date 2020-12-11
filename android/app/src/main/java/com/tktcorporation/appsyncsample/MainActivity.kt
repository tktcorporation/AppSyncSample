package com.tktcorporation.appsyncsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.amazonaws.mobile.config.AWSConfiguration
import com.amplifyframework.AmplifyException
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.AWSDataStorePlugin

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    try {
      Amplify.addPlugin(AWSDataStorePlugin())
      Amplify.configure(applicationContext)
      Log.i("Tutorial", "Initialized Amplify")
    } catch (failure: AmplifyException) {
      Log.e("Tutorial", "Could not initialize Amplify", failure)
    }
  }
}
