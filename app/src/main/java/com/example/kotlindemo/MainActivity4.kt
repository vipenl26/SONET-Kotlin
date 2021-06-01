package com.example.kotlindemo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        var btn=findViewById<Button>(R.id.btn)
        var firstOperator=findViewById<TextView>(R.id.firstOperand)
        var secondOperator=findViewById<TextView>(R.id.secondOperand)
        var operator=findViewById<Spinner>(R.id.operator)
        var result=findViewById<TextView>(R.id.result)

        btn.setOnClickListener(View.OnClickListener {
            var a=firstOperator.text.toString().toDouble()
            var b=secondOperator.text.toString().toDouble()
            var op=operator.selectedItem.toString()
            var res=""

            if(op=="+"){
                res="Result: ${a+b}"
            }
            else if(op=="-"){
                res="Result: ${a-b}"
            }
            else if(op=="*"){
                res="Result: ${a*b}"
            }
            else if(op=="/"){
                res="Result: ${a/b}"
            }
            else if(op=="%"){
                res="Result: ${a%b}"
            }
            else{
                res="please select operator"
            }
            result.text=res

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