package com.example.mod6intent
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import android.Manifest

class MainActivity : AppCompatActivity() {
    val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()){
            if(it) {
                val dialMai = Intent(Intent.ACTION_CALL, Uri.parse("tel:+33685095038"))
                startActivity(dialMai)
            }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //intent explicit  : on appelle directemnt l'activité
        val intentSettings = Intent(this,SettingsActivity::class.java)

        //intent implicite : on passe par l'intent manager, on laisse le système decider quelle application executée avec ACTION_DIAL
        val dialMai = Intent(Intent.ACTION_DIAL, Uri.parse("tel:+33685095038"))


        findViewById<Button>(R.id.buttonExplicite).setOnClickListener{
            startActivity(intentSettings)
        }
        findViewById<Button>(R.id.ButtonImplicite).setOnClickListener {
            startActivity(dialMai)
        }
        findViewById<Button>(R.id.ButtonPermission).setOnClickListener {
            requestPermissionLauncher.launch(Manifest.permission.CALL_PHONE)
        }

    }
}