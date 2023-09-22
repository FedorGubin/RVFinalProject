package com.example.rvfinalproject

/**
 * Источник данных для списка сообщений*/
class MyDataSourceImpl : MyDataSource {

    /** все сообщения */
    private val sourceItems = listOf(
        MessageCard(
            title = "Tinkoff",
            text = "Пополнение, счет RUB. 280 RUB. Семён П. Доступно 766.3 RUB",
            image = R.drawable.fedosik,
            time = "14:27",
        ),
        MessageCard(
            title = "900",
            text = "Скидка 15% на заём до 25.09 Промокод: DR Ссылка: belkacredit.ru/su/DR",
            image = R.drawable.dimasik,
            time = "07:06",
        )
    )

    /** Возвращает список всех сообщений */
    override fun getData(): List<MessageCard> {
        return sourceItems
    }
}