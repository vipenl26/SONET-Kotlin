package com.example.kotlindemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import kotlin.math.pow

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var btn = findViewById<Button>(R.id.btn)
        var txtInput=findViewById<TextView>(R.id.txtinput);
        var txtView=findViewById<TextView>(R.id.txtview);


        btn.setOnClickListener(View.OnClickListener {
            // Code here executes on main thread after user presses button

            var n=txtInput.text.toString().toInt()
            var radius:Double=0.0;
            var res:String=""

            for(i in 1 until n){
                res+="$i@"
            }
            res+="$n"
            txtView.text=res
            txtInput.text=""

            closeKeyboard()

        })


    }





    private fun closeKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm: InputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

}