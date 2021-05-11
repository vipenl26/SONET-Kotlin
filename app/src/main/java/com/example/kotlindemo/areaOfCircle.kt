package com.example.kotlindemo

import kotlin.math.pow


fun main(){
    println("enter radius of the circle")
    var radius:Double= readLine()!!.toDouble()
    val pi=3.14

    val area=pi* radius.pow(2.0)
    println("area of the circle is $area")


}