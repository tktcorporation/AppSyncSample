package com.tktcorporation.appsyncsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.amplifyframework.api.ApiException
import com.amplifyframework.api.graphql.model.ModelMutation
import com.amplifyframework.core.Amplify
import com.amplifyframework.datastore.generated.model.Todo
import com.tktcorporation.appsyncsample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

  private lateinit var binding: ActivityMainBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    val view = binding.root
    setContentView(view)

    binding.createButton.setOnClickListener {
      createToDo(binding.todoName.text.toString(), binding.todoDescription.text.toString())
    }
  }

  private fun createToDo(name: String, description: String) {
    val todo: Todo = Todo.builder()
      .name(name)
      .description(description)
      .build()

    Amplify.API.mutate(
      ModelMutation.create(todo),
      { response -> Log.i("MyAmplifyApp", "Added Todo with id: " + response.getData().getId()) },
      { error: ApiException? -> Log.e("MyAmplifyApp", "Create failed", error) }
    )
  }
}
