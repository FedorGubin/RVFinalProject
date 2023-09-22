package com.example.rvfinalproject

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.rvfinalproject.databinding.MassageCardSmsBinding
import com.example.rvfinalproject.databinding.MessageCardEmailBinding

// TODO(Зачем и кому он нужен?)
class DataAdapter : RecyclerView.Adapter<ViewHolder>() {
    // TODO(Что хранит переменная. Как потом использует её адаптер)
    private val items = mutableListOf<MessageCard>()

    // TODO(Что происходит в этом методе. Разобрать каждую строку)
    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<MessageCard>) {
        items.clear()
        items.addAll(data)
        notifyDataSetChanged()
    }

    // TODO(Для чего определять тип view)
    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is MessageCard.MessageCardSMS -> TYPE_SMS
            is MessageCard.MessageCardEmail -> TYPE_EMAIL
        }
    }

    // TODO(Для чего адптер вызывает этот метод. Как использовать viewType)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            TYPE_SMS -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.massage_card_sms, parent, false)
                HolderSMS(view)
            }
            TYPE_EMAIL -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.message_card_email, parent, false)
                HolderEmail(view)
            }
            else -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.massage_card_sms, parent, false)
                HolderSMS(view)
            }
        }
    }

    // TODO(Тоже для чего вызывается. Откуда приходит параметр [holder])
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is HolderSMS -> holder.bind(items[position] as MessageCard.MessageCardSMS)
            is HolderEmail -> holder.bind(items[position] as MessageCard.MessageCardEmail)
        }
    }
    // TODO(Ну и для чего это ?)
    override fun getItemCount(): Int {
        return items.size
    }

    // TODO(Что такое класс ViewHolder. Зачем он принимает view. И как их может быть несколько)
    class HolderSMS constructor(view: View) : ViewHolder(view) {

        private val binding: MassageCardSmsBinding = MassageCardSmsBinding.bind(view)
        fun bind(item: MessageCard.MessageCardSMS) {
            binding.photo.setImageResource(item.image)
            binding.title.text = item.title
            binding.time.text = item.time
            binding.text.text = item.text
        }
    }

    class HolderEmail constructor(view: View) : ViewHolder(view) {
        private val binding: MessageCardEmailBinding = MessageCardEmailBinding.bind(view)

        fun bind(item: MessageCard.MessageCardEmail) {
            binding.photo.setImageResource(item.image)
            binding.title.text = item.title
            binding.subtitle.text = item.subtitle
            binding.time.text = item.time
            binding.text.text = item.text
        }
    }

    companion object {
        private const val TYPE_SMS = 1
        private const val TYPE_EMAIL = 2
    }
}
