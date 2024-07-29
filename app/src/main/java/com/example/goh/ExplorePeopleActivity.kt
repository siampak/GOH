package com.example.goh

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.goh.adapter.PeopleAdapter
import com.example.goh.databinding.ActivityExplorePeopleBinding
import com.example.goh.network.RetrofitExplorePeople
import com.example.goh.repository.ExplorePeopleRepository
import com.example.goh.userinterface.ExplorePeopleApiService
import com.example.goh.viewModel.ExplorePeopleViewModel

class ExplorePeopleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityExplorePeopleBinding
    private val viewModel: ExplorePeopleViewModel by viewModels {
        ExplorePeopleViewModel.ExplorePeopleViewModelFactory(
            ExplorePeopleRepository(
                RetrofitExplorePeople.create(
                    ExplorePeopleApiService::class.java
                )
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExplorePeopleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvPeopleYouMayKnow.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val adapter = PeopleAdapter()
        binding.rvPeopleYouMayKnow.adapter = adapter

        viewModel.explorePeople.observe(this, Observer {
            it?.let {
                adapter.submitList(it.results!!)
            }
        })

        viewModel.fetchExplorePeople()
    }


}