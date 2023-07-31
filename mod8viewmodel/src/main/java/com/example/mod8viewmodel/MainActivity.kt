package com.example.mod8viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.mod8viewmodel.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val vm by viewModels<ArticleViewViewModel> ()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.vm = vm

        binding.lifecycleOwner =this
        //binding.textViewCounter.text = vm.compteur.toString()
        binding.floattingActionBution.setOnClickListener {
            //binding.textViewCounter.text = vm.inc().toString()
            vm.inc()
        }
    }
}