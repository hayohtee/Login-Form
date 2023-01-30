package com.hayohtee.loginform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    companion object {
        // map username with password for registered users
        val registeredUsers = mapOf(
            "john_doe" to "john123",
            "marie.james" to "marie36",
            "mad_dog" to "paul21",
            "hayohtee" to "olamilekan47"
        )
    }

}