package com.example.kotlindemo

fun main(){
    var n=1;
    when(n){
        1->print("hello")
        in 1..10->print("world")
        else ->print("nothing")
    }
}