package com.example.dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.dice.databinding.ActivityDiceBinding

class DiceActivity : AppCompatActivity() {

    lateinit var binding : ActivityDiceBinding
    val vm by viewModels<DiceViewModel> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_dice)
        binding.vm=vm

        //permet au binding d'observer les changements de données des livedata
        binding.lifecycleOwner = this
        vm.dice.observe(this){
        }

    }
}