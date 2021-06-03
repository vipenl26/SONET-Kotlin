package com.example.kotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        var btn = findViewById<Button>(R.id.btn)
        var nameBlock = findViewById<TextView>(R.id.nameBlock)
        var ageBlock = findViewById<TextView>(R.id.ageBlock)
        var genderBlock = findViewById<TextView>(R.id.genderBlock)

        btn.setOnClickListener {
            val p=Person()
            p.name = nameBlock.text.toString()
            p.gender = genderBlock.text.toString()
            p.age = ageBlock.text.toString().toInt()

            var result = if(p.age>=18) "you can enter ${p.name}" else "you cannot enter ${p.name}"

            Toast.makeText(this, result, Toast.LENGTH_LONG).show()



        }

    }
}