package com.example.chatgptretrofit

import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ChatGptInterface {

    // tood make GET parameter an END_POINT
    @GET("api/chatgpt/{question}")
    fun getResponse(@Path("question") question: String): Call<JsonObject>
}
