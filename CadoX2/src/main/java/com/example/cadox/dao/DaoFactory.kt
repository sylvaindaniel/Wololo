package com.example.cadox.dao

import com.example.cadox.dao.memory.ArticleDaoMemoryImpl

object DaoFactory {
    fun createDaoByType(type: DaoType): ArticleDao {
        return when(type){
            DaoType.MEMORY -> ArticleDaoMemoryImpl()
        }
    }
}