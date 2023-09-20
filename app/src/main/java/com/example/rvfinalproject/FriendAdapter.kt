package com.example.rvfinalproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rvfinalproject.databinding.CardsBinding

class FriendAdapter : RecyclerView.Adapter<FriendAdapter.MyHolder>() {
   private val friendList = ArrayList<Friends>()

    class MyHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = CardsBinding.bind(item)
        fun bind(friends: Friends) {
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

    fun addCard(friends: Friends) {
        friendList.add(friends)
        notifyItemInserted(friendList.size - 1)
    }
}