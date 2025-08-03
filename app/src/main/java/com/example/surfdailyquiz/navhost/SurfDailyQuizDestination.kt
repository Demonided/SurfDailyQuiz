package com.example.surfdailyquiz.navhost

interface SurfDailyQuizNavigationDestinations {
    val route: String
}

object Home : SurfDailyQuizNavigationDestinations {
    override val route: String
        get() = "homeScreen"
}

object Quiz : SurfDailyQuizNavigationDestinations {
    override val route: String
        get() = "quizScreen"
}

object Finish : SurfDailyQuizNavigationDestinations {
    override val route: String
        get() = "finishScreen"
}

object History : SurfDailyQuizNavigationDestinations {
    override val route: String
        get() = "historyScreen"
}