package com.example.cadox.ui

import androidx.lifecycle.ViewModel
import com.example.cadox.repository.ArticleRepository

class ArticleViewViewModel : ViewModel() {

    var article = ArticleRepository.getArticle(0L)
}