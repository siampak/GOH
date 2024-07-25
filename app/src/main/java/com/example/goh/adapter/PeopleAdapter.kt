package com.example.goh.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.goh.R
import com.example.goh.dataClass.PeopleResult
import com.example.goh.databinding.ItemAddFriendBinding

class PeopleAdapter : RecyclerView.Adapter<PeopleAdapter.PeopleViewHolder>() {

    private var peopleList: List<PeopleResult?> = listOf()

    fun submitList(list: List<PeopleResult?>) {
        peopleList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val binding = ItemAddFriendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PeopleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        val person = peopleList[position]
        holder.bind(person)
    }

    override fun getItemCount(): Int {
        return peopleList.size
    }

    class PeopleViewHolder(private val binding: ItemAddFriendBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(person: PeopleResult?) {
            person?.let {

                binding.tvName.text = it.fullName
                Glide.with(binding.root.context)
                    .load(it.dp)
                    .placeholder(R.drawable.goh_profile)
                    .into(binding.gohProfileImage)
            }
        }
    }
}