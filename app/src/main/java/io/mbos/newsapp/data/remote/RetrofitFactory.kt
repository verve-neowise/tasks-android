package io.mbos.newsapp.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitFactory {

    private val BASE_URL = "https://jsonplaceholder.typicode.com"

    private val retrofit by lazy { buildRetrofit() }

    private fun buildRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun newsService() = retrofit.create(NewsService::class.java)
}