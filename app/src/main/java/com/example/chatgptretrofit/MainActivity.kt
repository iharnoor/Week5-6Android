package com.example.chatgptretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.chatgptretrofit.databinding.ActivityMainBinding
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addButton.setOnClickListener {


            val retrofit = RetrofitClient.getInstance()
            val apiInterface = retrofit.create(ChatGptInterface::class.java)

            val question = binding.inputEdit.text.toString()

//            val call: Call<JsonObject> = apiInterface.getResponse("what's 1+1")
            val call: Call<JsonObject> = apiInterface.getResponse(question)

            call.enqueue(object : Callback<JsonObject> {
                override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                    Log.d("HARRY", response.body().toString())
                    Toast.makeText(
                        it.context,
                        "result: " + response.body().toString(),
                        Toast.LENGTH_SHORT
                    ).show()
                    binding.outputText.text = response.body().toString()
                }

                override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                    t.printStackTrace()
                    Log.d("HARRY Error", t.toString())!!
                }
            })
        }
    }


}