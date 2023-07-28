package com.example.mod4findview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.mod4findview.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main)
        //val textView = findViewById<TextView>(R.id.textView)
        activityMainBinding.textView.text="Hello bande de nazes ! 😆"
        activityMainBinding.textView.textSize = 25f
        activityMainBinding.user=User("Jean-Paul","RIVERAU",68)

        //val button = findViewById<Button>(R.id.button)
        activityMainBinding.button.setOnClickListener {
            Toast.makeText(this,"Hello World !", Toast.LENGTH_SHORT).show()
            it.isEnabled = false
            Snackbar.make(it,"Hellsoeitjsoigj ",Snackbar.LENGTH_SHORT).show()
        }
    }
}