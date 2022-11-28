package io.mbos.newsapp.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {

    private val BASE_URL = "http://neowise.uz:8080/"

    private val retrofit by lazy { buildRetrofit() }

    private fun buildRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun tasksService(): TasksService = retrofit.create(TasksService::class.java)
}