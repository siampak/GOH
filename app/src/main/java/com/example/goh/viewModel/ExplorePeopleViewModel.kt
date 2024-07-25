package com.example.goh.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.goh.dataClass.ExplorePeople
import com.example.goh.repository.ExplorePeopleRepository

class ExplorePeopleViewModel (private val repository: ExplorePeopleRepository) : ViewModel() {

    val explorePeople: LiveData<ExplorePeople> get() = repository.explorePeople

    fun fetchExplorePeople() {
        repository.fetchExplorePeople()
    }


    class ExplorePeopleViewModelFactory(private val repository: ExplorePeopleRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(ExplorePeopleViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return ExplorePeopleViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
        }

}