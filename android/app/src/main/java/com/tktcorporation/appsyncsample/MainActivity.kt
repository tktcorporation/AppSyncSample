package com.tktcorporation.appsyncsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tktcorporation.appsyncsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
  private lateinit var binding: ActivityMainBinding
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    binding.button.setOnClickListener {
      createUser(binding.textView.text.toString())
    }
  }

  private fun createUser(name: String) {

  }
}
