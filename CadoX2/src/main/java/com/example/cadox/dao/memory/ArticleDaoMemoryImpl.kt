package com.example.cadox.dao.memory

import com.example.cadox.bo.Article
import com.example.cadox.dao.ArticleDao
import java.time.LocalDate

class ArticleDaoMemoryImpl : ArticleDao {

    companion object {
        val listArticles = mutableListOf(

            Article(0L,
                "Ordinateur Dell",
                "Ordinateur qui calcule",
                850.0,
                4,"https://tourch.bzh/",true, LocalDate.now()
            )
        )
    }

    override fun selectById(id: Long) :Article?{
        return listArticles.find {it.id == id}
    }

    override fun update(article: Article) {
        listArticles.removeIf {it.id == article.id }
        listArticles.add(article)

    }

}