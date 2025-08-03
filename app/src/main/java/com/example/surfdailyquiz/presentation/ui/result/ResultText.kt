package com.example.surfdailyquiz.presentation.ui.result

data class ResultText(
    val title: String ,
    val subtitle: String
)

object ResultTextProvider {
    fun getResultText(score: Int): ResultText {
        return when (score) {
            5 -> ResultText(
                title = "Идеально!" ,
                subtitle = "5/5 — вы ответили на всё правильно. Это блестящий результат!"
            )

            4 -> ResultText(
                title = "Почти идеально!" ,
                subtitle = "4/5 — очень близко к совершенству. Ещё один шаг!"
            )

            3 -> ResultText(
                title = "Хороший результат!" ,
                subtitle = "3/5 — вы на верном пути. Продолжайте тренироваться!"
            )

            2 -> ResultText(
                title = "Есть над чем поработать" ,
                subtitle = "2/5 — не расстраивайтесь, попробуйте ещё раз!"
            )

            1 -> ResultText(
                title = "Сложный вопрос?" ,
                subtitle = "1/5 — иногда просто не ваш день. Следующая попытка будет лучше!"
            )

            0 -> ResultText(
                title = "Бывает и так!" ,
                subtitle = "0/5 — не отчаивайтесь. Начните заново и удивите себя!"
            )

            else -> ResultText(
                title = "Ошибка" ,
                subtitle = "Некорректное количество правильных ответов: $score"
            )
        }
    }
}
