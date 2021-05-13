package com.example.kotlindemo

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Spinner
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var layout=findViewById<ConstraintLayout>(R.id.parent)
        var button=findViewById<Button>(R.id.selectBtn)
        var spinner=findViewById<Spinner>(R.id.spinner)

        button.setOnClickListener(View.OnClickListener {
            var color:String=spinner.selectedItem.toString()

            when(color){
                "Blue"->layout.setBackgroundColor(Color.BLUE)
                "Gray"->layout.setBackgroundColor(Color.GRAY)
                "Red"->layout.setBackgroundColor(Color.RED)
                "Yellow"->layout.setBackgroundColor(Color.YELLOW)
                "Green"->layout.setBackgroundColor(Color.GREEN)
            }

        })
    }
}