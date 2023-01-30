package com.hayohtee.loginform

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    val username = result.data?.getStringExtra(MESSAGE_KEY)
                    findViewById<TextView>(R.id.welcome).text = username
                }
            }

        val intent = Intent(this, FormActivity::class.java)
        resultLauncher.launch(intent)
    }
}