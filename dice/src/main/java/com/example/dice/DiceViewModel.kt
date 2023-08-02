package com.example.dice

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DiceViewModel : ViewModel() {
    var dice = MutableLiveData(0)

    fun launchDice(max : Int){
        var min = 1
        dice.value = (min..max).random()
    }
}