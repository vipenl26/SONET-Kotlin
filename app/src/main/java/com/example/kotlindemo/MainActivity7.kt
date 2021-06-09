package com.example.kotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class MainActivity7 : AppCompatActivity() {
    var turn=1
    var moves=0
    var mat=arrayOf(arrayOf(0,0,0),arrayOf(0,0,0),arrayOf(0,0,0))
    var gameOver=false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

    }
    fun equals(a:Int,b:Int,c:Int):Boolean{
        return (a==b && b==c && a!=0)
    }
    fun isGame():Boolean{
        if(equals(mat[0][0],mat[0][1],mat[0][2]) ||
            equals(mat[1][0],mat[1][1],mat[1][2]) ||
            equals(mat[2][0],mat[2][1],mat[2][2])){
            return true
        }
        if(equals(mat[0][0],mat[1][0],mat[2][0]) ||
            equals(mat[0][1],mat[1][1],mat[2][1]) ||
            equals(mat[0][2],mat[1][2],mat[2][2])){
            return true
        }
        if(equals(mat[0][0],mat[1][1],mat[2][2]) ||
                equals(mat[0][2],mat[1][1],mat[2][0])){
            return true
        }

        return false
    }
    fun coinAppear(view: View){
        if(gameOver){
            return
        }
        val img: ImageView =view as ImageView
        var r:Int= img.tag.toString()[0]-'0'
        var c:Int= img.tag.toString()[1]-'0'
        mat[r-1][c-1]=turn
        Log.i("tag","$r $c")


        var st=findViewById<TextView>(R.id.gameStatus)

        if(turn==1)img.setImageResource(R.drawable.black)
        else img.setImageResource(R.drawable.white)


        if(isGame()){
            gameOver=true
            if(turn==1){
                st.text="Black Won"
            }
            else{
                st.text="White Won"
            }

            return
        }
        turn=2/turn
        moves++
        if(moves==9){
            gameOver=true
            st.text="Draw"
            return
        }
        if(turn==1){
            st.text="Black to Play"
        }
        else{
            st.text="White to Play"
        }

    }
}