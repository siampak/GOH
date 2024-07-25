package com.example.goh.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitExplorePeople {
    private const val BASE_URL = "https://goh.life/"

         private val logging = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        private val tokenInterceptor = Interceptor { chain ->
            val originalRequest = chain.request()
            val token = "d6ad3e51971fe361d7800bc9566ad5ac726ddbc3b2920c60a6400557d417f9b32e8cd7ec462371f9a2e4443580fe7efe2a59ae98c508f6baabcf50fd094fbedfd5089074e6cebef0ddd3af3a4db6f45511c5d61575f12024eda0f71e365c8cc2f6e65d39243a23a3e3249e6003029739449815b58ca7a268b493d668897ec8a57e7c6f435b99bbc900d28ba8e525ff71a532f556141f"
            val newRequest = originalRequest.newBuilder()
                .header("Authorization", "Token $token")
                .build()
            chain.proceed(newRequest)
        }

    private val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .addInterceptor(tokenInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()





    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun <T> create(service: Class<T>): T {
        return retrofit.create(service)
    }
}