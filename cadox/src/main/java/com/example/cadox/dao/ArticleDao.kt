package com.example.cadox.dao

import com.example.cadox.bo.Article

interface ArticleDao {
    fun selectById(id: Long): Article?
}