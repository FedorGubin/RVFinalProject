package com.example.rvfinalproject

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.rvfinalproject.databinding.MassageCardBinding

class DataAdapter : RecyclerView.Adapter<DataAdapter.MyHolder>() {
    private val items = mutableListOf<MessageCard>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<MessageCard>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.massage_card, parent, false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class MyHolder constructor(view: View) : ViewHolder(view) {

        private val binding: MassageCardBinding = MassageCardBinding.bind(view)
        fun bind(item: MessageCard) {
            binding.photo.setImageResource(item.image)
            binding.title.text = item.title
            binding.time.text = item.time
            binding.text.text = item.text
        }
    }
}
