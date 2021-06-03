package com.example.kotlindemo

import java.lang.Exception
import java.util.*

class Person {
    var name:String?=null
    get(){
        return field
    }
    set(value){
        field= value?.uppercase(Locale.getDefault())
    }

    var gender:String?=null
    var age:Int=0
    get(){
        return field
    }
    set(value){
        if(value<18){
            field=value
//            throw Exception("person is minor")
        }
        else{
            field=value
        }
    }


}