package com.example.goh.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.goh.dataClass.ExplorePeople
import com.example.goh.userinterface.ExplorePeopleApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ExplorePeopleRepository(private val apiService: ExplorePeopleApiService) {

    private val _explorePeople = MutableLiveData<ExplorePeople>()
    val explorePeople: LiveData<ExplorePeople> get() = _explorePeople

    fun fetchExplorePeople() {
        apiService.getExplorePeople().enqueue(object : Callback<ExplorePeople> {
            override fun onResponse(call: Call<ExplorePeople>, response: Response<ExplorePeople>) {
                if (response.isSuccessful) {
                    _explorePeople.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<ExplorePeople>, t: Throwable) {

            }
        })
    }
}
