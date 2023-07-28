package com.example.cadox.dao.memory

import com.example.cadox.bo.Article
import com.example.cadox.dao.ArticleDao
import java.time.LocalDate

class ArticleDaoMemoryImpl : ArticleDao {
    override fun selectById(id: Long) :Article?{
        return Article(0L,
            "Ordinateur Dell",
            "Ordinateur qui calcule",
            850.0,
            4,null,null,null
        )
    }
}