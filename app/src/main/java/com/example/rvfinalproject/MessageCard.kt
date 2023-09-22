package com.example.rvfinalproject

// TODO(Ешё раз про sealed и переопределение переменных)
sealed interface MessageCard {

    val title: String
    val text: String
    val image: Int
    val time: String

    data class MessageCardSMS(
        override val title: String,
        override val text: String,
        override val image: Int,
        override val time: String,
    ) : MessageCard

    data class MessageCardEmail(
        override val title: String,
        val subtitle: String,
        override val text: String,
        override val image: Int,
        override val time: String,
    ) : MessageCard
}
