package com.example.kotlindemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
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
    fun playAgain(view:View){
        mat=arrayOf(arrayOf(0,0,0),arrayOf(0,0,0),arrayOf(0,0,0))
        turn=1
        moves=0
        gameOver=false
        findViewById<ImageView>(R.id.b11).setImageResource(0)
        findViewById<ImageView>(R.id.b12).setImageResource(0)
        findViewById<ImageView>(R.id.b13).setImageResource(0)
        findViewById<ImageView>(R.id.b21).setImageResource(0)
        findViewById<ImageView>(R.id.b22).setImageResource(0)
        findViewById<ImageView>(R.id.b23).setImageResource(0)
        findViewById<ImageView>(R.id.b31).setImageResource(0)
        findViewById<ImageView>(R.id.b32).setImageResource(0)
        findViewById<ImageView>(R.id.b33).setImageResource(0)

        findViewById<TextView>(R.id.gameStatus).text="Black to Play"
        findViewById<Button>(R.id.btn).visibility = View.GONE;

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
        if(mat[r-1][c-1]!=0){
            return
        }
        mat[r-1][c-1]=turn
        //Log.i("tag","$r $c")


        var st=findViewById<TextView>(R.id.gameStatus)
        var btn=findViewById<Button>(R.id.btn)

        if(turn==1)img.setImageResource(R.drawable.black)
        else img.setImageResource(R.drawable.white)


        if(isGame()){
            gameOver=true
            btn.visibility = View.VISIBLE;
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
            btn.visibility = View.VISIBLE;
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