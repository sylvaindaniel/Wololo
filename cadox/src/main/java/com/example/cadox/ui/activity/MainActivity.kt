package com.example.cadox.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import com.example.cadox.R
import com.example.cadox.databinding.ActivityMainBinding
import com.example.cadox.repository.ArticleRepository
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var amb: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //Log.d("MainActivity", "onCreate: ${ArticleRepository.getArticle(0)}")
        amb.article=ArticleRepository.getArticle(0L)

        amb.imageButtonEdit.setOnClickListener {
            val builder: AlertDialog.Builder = AlertDialog.Builder(this)
            builder.setMessage("Voulez-vous modifier cet article?")
                .setTitle("Edition Article")
                .setPositiveButton("oui", null)
                .setNegativeButton("Non", null)
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }
        amb.imageButtonUrl.setOnClickListener{
            Toast.makeText(this, amb.article?.url ?: "Pas d'URL", Toast.LENGTH_SHORT).show()
        }
        amb.imageButtonSend.setOnClickListener {
            Snackbar.make(amb.root, "Message envoyé", Snackbar.LENGTH_SHORT).show()
        }
    }
}