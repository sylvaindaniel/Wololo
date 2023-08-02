package com.example.mod5menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_app_bar_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            //toast
            R.id.menu_add -> Toast.makeText(this, "Ajouter", Toast.LENGTH_SHORT).show()
            R.id.menu_edit -> Toast.makeText(this, "Editer", Toast.LENGTH_SHORT).show()
            R.id.menu_del -> Toast.makeText(this, "Suppression !!!!!!!!!!!!!!!!!!! AAAAAAAAHHHHHHHHH !!!!!!!!", Toast.LENGTH_SHORT).show()


        }
        return super.onContextItemSelected(item)
    }
}