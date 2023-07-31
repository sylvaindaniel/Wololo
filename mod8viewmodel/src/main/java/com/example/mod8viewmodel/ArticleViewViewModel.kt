package com.example.mod8viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ArticleViewViewModel : ViewModel() {

    var compteur = MutableLiveData(0)
    fun inc() {
        compteur.value = compteur.value?.inc()
    }
}