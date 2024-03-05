package com.example.basicstudio

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Log.i("MyTag", "MainActivity : OnCreate")
                val greetingTextView = findViewById<TextView>(R.id.tvHello)
                val inputField = findViewById<EditText>(R.id.etName)
                val submitButton = findViewById<Button>(R.id.btnSubmit)
                val offerButton = findViewById<Button>(R.id.btnOffers)
                var enteredName = ""

                submitButton.setOnClickListener{
                    enteredName = inputField.text.toString()
                    if (enteredName == ""){
                        offerButton.visibility = INVISIBLE
                        greetingTextView.text = ""
                        Toast.makeText(this@MainActivity, "Please Enter your name", Toast.LENGTH_SHORT).show()
                    }else{
                        val message = "Welcome $enteredName!"
                        Log.i("MyTag", message)
                        greetingTextView.text = message
                        Log.i("MyTag", "After displaying te message on the textview")
                        inputField.text.clear()
                        offerButton.visibility = VISIBLE
                    }

                }

                //offers button listener
                offerButton.setOnClickListener{
                    val intent = Intent(this,SecondActivity::class.java)
                    intent.putExtra("USER", enteredName)
                    startActivity(intent)
                }

                ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
                    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                    v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                    insets
                }
    }
}