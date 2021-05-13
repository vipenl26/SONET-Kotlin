package com.example.kotlindemo

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btn = findViewById<Button>(R.id.btn)
        var radiusBlock=findViewById<TextView>(R.id.radiusBlock);
        var txtBottom=findViewById<TextView>(R.id.txtBottom);


        btn.setOnClickListener(View.OnClickListener {
            // Code here executes on main thread after user presses button
            var radius:Double=0.0;
            try{
                radius=radiusBlock.text.toString().toDouble()
                val pi=3.14

                var area=pi*radius.pow(2)
                txtBottom.text="Area of circle is $area"

            }
            catch(e:Throwable){
                txtBottom.text="enter only digits[0-9 and .].. \n please try again"
            }
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

