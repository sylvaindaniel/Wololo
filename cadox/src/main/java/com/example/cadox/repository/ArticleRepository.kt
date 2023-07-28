package com.example.cadox.repository

import com.example.cadox.bo.Article
import com.example.cadox.dao.DaoFactory
import com.example.cadox.dao.DaoType

object ArticleRepository {
    private val daoMemory = DaoFactory.createDaoByType(DaoType.MEMORY)
    fun getArticle(id: Long): Article?{
        return daoMemory.selectById(id)
    }
}