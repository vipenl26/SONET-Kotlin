package com.example.kotlindemo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn = findViewById<Button>(R.id.btn)
        var txt = findViewById<TextView>(R.id.txt);

        var flag=false;
        btn.setOnClickListener(View.OnClickListener {
            // Code here executes on main thread after user presses button
            if(flag){
                txt.text = "Aak is Pak"
                flag = false;
            }
            else {
                txt.text = "Pak is Aak"
                flag = true;
            }

        })

    }
}

