package com.example.rvfinalproject

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rvfinalproject.databinding.CardsBinding

class FriendAdapter : RecyclerView.Adapter<FriendAdapter.MyHolder>() {
   private val friendList = ArrayList<Friend>()

    class MyHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = CardsBinding.bind(item)
        fun bind(friends: Friend) {
            binding.apply {
                photo.setImageResource(friends.img)
                name.text = friends.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cards, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(friendList[position])
    }

    override fun getItemCount(): Int {
        return friendList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setFriends(friends: List<Friend>) {
        friendList.clear()
        friendList.addAll(friends)
        notifyDataSetChanged()
    }
}