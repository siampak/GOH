package com.example.goh.userinterface

import com.example.goh.dataClass.ExplorePeople
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface ExplorePeopleApiService {
        @GET("api/user_search/")
        fun getExplorePeople(): Call<ExplorePeople>
    }




