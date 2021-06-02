package com.example.kotlindemo

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity5 : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        val btn=findViewById<Button>(R.id.btn)
        val leftInput=findViewById<TextView>(R.id.temp)
        val rightInput=findViewById<TextView>(R.id.dirt)
        val output1=findViewById<TextView>(R.id.output1)
        val output2=findViewById<TextView>(R.id.output2)
        var output0=findViewById<TextView>(R.id.output0)

        btn.setOnClickListener {
            val day = randomDay()
            val food = fishFood(day)
            val dirt = rightInput.text.toString().toInt()
            val temp = leftInput.text.toString().toInt()

            output0.text="It's $day"
            if (changeWater(day, dirt, temp)) {
                output1.text = "Change Water"
            } else {
                output1.text = "Don't change Water"
            }

            output2.text = "Feed $food to Fish today"

        }
    }
}

fun randomDay(): String {
    val n: Int = Random().nextInt(7)

    return arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")[n]
}

fun fishFood(day:String):String{
    var res =""
    when(day){
        "Monday" ->res="flakes"
        "Tuesday" ->res="pellets"
        "Wednesday" ->res="redworms"
        "Thursday"->res="granules"
        "Friday" -> res="mosquitoes"
        "Saturday" -> res="lettuce"
        "Sunday" -> res="plankton"
    }
    return res
}
fun changeWater(day:String,dirt:Int,temp:Int):Boolean{
    if(day=="Sunday" || dirt>30 || temp>30){
        return true
    }
    return false
}