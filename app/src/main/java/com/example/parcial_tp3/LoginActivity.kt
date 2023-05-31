package com.example.parcial_tp3

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)

        buttonLogin.setOnClickListener(){
            val editText : EditText = findViewById<EditText>(R.id.nameLogin)
            val textNombre : String = editText.text.toString()

            val intent = Intent(this, MainActivity::class.java)
            val bundle = Bundle()

            bundle.putString("textoExtra",textNombre)
            intent.putExtras(bundle)
            startActivity(intent)
            finish()
        }

    }
}