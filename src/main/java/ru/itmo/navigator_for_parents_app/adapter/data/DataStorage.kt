package ru.itmo.navigator_for_parents_app.adapter.data


object DataStorage {
    private val prev: String = ""

    fun getArticleImportantList(): List<Articles> {
        return listOf(
            Articles(
                "Первая статья",
                "Описание для первой статьи"
            ),
            Articles(
                "Вторая статья",
                "Описание для второй статьи"
            ),
            Articles(
                "Третья статья",
                "Описание для третьей статьи"
            )
        )
    }

    fun getArticleAgeList(): List<Articles> {
        return listOf(
            Articles(
                "Первая статья",
                "Описание для первой статьи"
            ),
        )
    }

    fun getArticleCrisisList(): List<Articles> {
        return listOf(
            Articles(
                "Первая статья",
                "Описание для первой статьи"
            ),
            Articles(
                "Вторая статья",
                "Описание для второй статьи"
            ),
            Articles(
                "Третья статья",
                "Описание для третьей статьи"
            ),
            Articles(
                "Четвертая статья",
                "Описание для четвертой статьи"
            ),
            Articles(
                "Пятая статья",
                "Описание для пятой статьи"
            ),
            Articles(
                "Шестая статья",
                "Описание для шестой статьи"
            ),
            Articles(
                "Первая статья",
                "Описание для первой статьи"
            ),
            Articles(
                "Вторая статья",
                "Описание для второй статьи"
            ),
            Articles(
                "Третья статья",
                "Описание для третьей статьи"
            ),
            Articles(
                "Четвертая статья",
                "Описание для четвертой статьи"
            ),
            Articles(
                "Пятая статья",
                "Описание для пятой статьи"
            ),
            Articles(
                "Шестая статья",
                "Описание для шестой статьи"
            )
        )
    }
}


