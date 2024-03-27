package com.example.numberpuzal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class startpage : AppCompatActivity() {

    lateinit var start : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.startpage)

        start=findViewById(R.id.start)
        start.setOnClickListener {
            startActivity(Intent(this@startpage,MainActivity::class.java))
            finish()
        }
    }
}