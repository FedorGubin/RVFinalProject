package com.example.rvfinalproject


// TODO(Что даёт нам создание интерфейса и что даёт приставка sealed)
// TODO(Просмотреть классы наследники)
sealed interface MyDataSource {
    fun getData(): List<MessageCard>
}

/**
 * Источник данных для списка сообщений*/
class MyDataSourceSMSImpl : MyDataSource {

    /** все сообщения */
    private val sourceItems = listOf(
        MessageCard.MessageCardSMS(
            title = "Tinkoff",
            text = "Пополнение, счет RUB. 280 RUB. Семён П. Доступно 766.3 RUB",
            image = R.drawable.fedosik,
            time = "14:27",
        ),
        MessageCard.MessageCardSMS(
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

class MyDataSourceEmailImpl : MyDataSource {

    private val sourceItems = listOf(
        MessageCard.MessageCardEmail(
            title = "Платформа ОФД",
            subtitle = "Получите на 25% больше денег сегодня!",
            text = "Акция завершится 22 сентября в 23:59 МСК.\n" +
                    "Пополните свой рекламный баланс сегодня и моментально получите дополнительный бонус +25% к любой сумме пополнения.",
            image = R.drawable.vitek,
            time = "13:07",
        ),
        MessageCard.MessageCardEmail(
            title = "Nintendo",
            subtitle = "Уважаемый инвестор!\n" +
                    "\n" +
                    "Отчёт брокера приложен к письму",
            text = "На сайте СберБанка есть инструкции, как читать отчёт: https://s.sber.ru/ZmKsN\n" +
                    "и как сохранить его в формате PDF: https://s.sber.ru/Sz2qw\n" +
                    "\n" +
                    "Изменение режима торгов",
            image = R.drawable.lexa,
            time = "09:33",
        )
    )

    override fun getData(): List<MessageCard> {
        return sourceItems
    }

}