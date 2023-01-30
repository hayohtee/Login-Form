package com.hayohtee.loginform

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import com.google.android.material.button.MaterialButton

const val MESSAGE_KEY = "MESSAGE"

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        findViewById<MaterialButton>(R.id.login).setOnClickListener {
            hideKeyboard()
            val usernameTextView = findViewById<TextView>(R.id.username)
            val passwordTextView = findViewById<TextView>(R.id.password)

            if (usernameTextView.text.isNotEmpty() && passwordTextView.text.isNotEmpty()) {
                val username = usernameTextView.text.toString().trim()
                val password = passwordTextView.text.toString().trim()
                val errorTextView = findViewById<TextView>(R.id.error)

                if (!registeredUsers.containsKey(username)) {
                    errorTextView.text = getString(R.string.error_username, username)
                    errorTextView.isVisible = true
                } else if (registeredUsers[username] != password) {
                    errorTextView.text = getString(R.string.error_password)
                    errorTextView.isVisible = true
                } else {
                    val intent = Intent().apply {
                        putExtra(MESSAGE_KEY, getString(R.string.welcome_text, username))
                    }

                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }

            } else {
                Toast.makeText(
                    baseContext, "Please fill all the fields",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
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

    private fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
    }
}