package com.example.dice

import androidx.lifecycle.ViewModel

class DiceViewModel : ViewModel() {
    var dice = 0

    fun launchDice(max : Int){
        var min = 1
        (min..max).random()
    }
}