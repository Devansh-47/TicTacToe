package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , View.OnClickListener{

    lateinit var board:Array<Array<Button>>
    lateinit var boardstatus:Array<Array<Int>>

    var txt="";
    var flag:Boolean=true
    var count:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt=txt+"Player X turn"
        textbox.setText(txt)
        txt=""
        board= arrayOf(arrayOf(button1,button2,button3),
                        arrayOf(button4,button5,button6),
                        arrayOf(button7,button8,button9))

        boardstatus= arrayOf(arrayOf(-1,-1,-1),
            arrayOf(-1,-1,-1),arrayOf(-1,-1,-1))


        for(i:Array<Button> in board){
            for (button:Button in i){
                button.setOnClickListener(this)
            }
        }


        reset.setOnClickListener{
            resetboard()
            textbox.setText("Lets Begin!!")
        }


    }


    override fun onClick(p0: View?) {
        if (p0 != null) {
            when(p0.id){
                R.id.button1->{
                    if(flag){
                        button1.text = "X"
                        count++
                        boardstatus[0][0]=1
                        txt="Player Y turn"
                        textbox.setText(txt)
                        flag=!flag

                    }
                    else{
                        button1.text = "O"
                        count++
                        boardstatus[0][0]=0
                        txt="Player X turn"
                        textbox.setText(txt)
                        flag=!flag
                    }
                    disablebtn(button1)

                }
                R.id.button2->{
                    if(flag){
                        button2.text = "X"
                        count++
                        boardstatus[0][1]=1
                        txt="Player Y turn"
                        textbox.setText(txt)
                        flag=!flag

                    }
                    else{
                        button2.text = "O"
                        count++
                        boardstatus[0][1]=0
                        txt="Player X turn"
                        textbox.setText(txt)
                        flag=!flag
                    }
                    disablebtn(button2)
                }
                R.id.button3->{
                    if(flag){
                        button3.text = "X"
                        count++
                        boardstatus[0][2]=1
                        txt="Player Y turn"
                        textbox.setText(txt)
                        flag=!flag

                    }
                    else{
                        button3.text = "O"
                        count++
                        boardstatus[0][2]=0
                        txt="Player X turn"
                        textbox.setText(txt)
                        flag=!flag
                    }
                    disablebtn(button3)
                }
                R.id.button4->{
                    if(flag){
                        button4.text = "X"
                        count++
                        boardstatus[1][0]=1
                        txt="Player Y turn"
                        textbox.setText(txt)
                        flag=!flag

                    }
                    else{
                        button4.text = "O"
                        count++
                        boardstatus[1][0]=0
                        txt="Player X turn"
                        textbox.setText(txt)
                        flag=!flag
                    }
                    disablebtn(button4)
                }
                R.id.button5->{
                    if(flag){
                        button5.text = "X"
                        count++
                        boardstatus[1][1]=1
                        txt="Player Y turn"
                        textbox.setText(txt)
                        flag=!flag

                    }
                    else{
                        button5.text = "O"
                        count++
                        boardstatus[1][1]=0
                        txt="Player X turn"
                        flag=!flag
                        textbox.setText(txt)
                    }
                    disablebtn(button5)
                }
                R.id.button6->{
                    if(flag){
                        button6.text = "X"
                        count++
                        boardstatus[1][2]=1
                        flag=!flag
                        txt="Player Y turn"
                        textbox.setText(txt)

                    }
                    else{
                        button6.text = "O"
                        count++
                        boardstatus[1][2]=0
                        txt="Player X turn"
                        flag=!flag
                        textbox.setText(txt)
                    }
                    disablebtn(button6)
                }
                R.id.button7->{
                    if(flag){
                        button7.text = "X"
                        count++
                        boardstatus[2][0]=1
                        txt="Player Y turn"
                        flag=!flag
                        textbox.setText(txt)

                    }
                    else{
                        button7.text = "O"
                        count++
                        boardstatus[2][0]=0
                        txt="Player X turn"
                        textbox.setText(txt)
                        flag=!flag
                    }
                    disablebtn(button7)
                }
                R.id.button8->{
                    if(flag){
                        button8.text = "X"
                        count++
                        boardstatus[2][1]=1
                        txt="Player Y turn"
                        flag=!flag
                        textbox.setText(txt)

                    }
                    else{
                        button8.text = "O"
                        count++
                        flag=!flag
                        boardstatus[2][1]=0
                        txt="Player X turn"
                        textbox.setText(txt)
                    }
                    disablebtn(button8)
                }
                R.id.button9->{
                    if(flag){
                        button9.text = "X"
                        count++
                        boardstatus[2][2]=1
                        flag=!flag
                        txt="Player Y turn"
                        textbox.setText(txt)

                    }
                    else{
                        button9.text = "O"
                        count++
                        flag=!flag
                        boardstatus[2][2]=0
                        txt="Player X turn"
                        textbox.setText(txt)
                    }
                    disablebtn(button9)
                }
            }
        }
        checkwinstatus()
        checkcount()
    }

    fun checkcount(){
        if(count==9){
            textbox.text="Match Draw!!"
            clearboard()
        }
    }
    fun checkwinstatus(){

        //checking rows
        for(i in 0..2){
            if(boardstatus[i][0]==boardstatus[i][1] && boardstatus[i][0]==boardstatus[i][2] && (boardstatus[i][0]==1 || boardstatus[i][0]==0)){
                if(boardstatus[i][0]==1)
                {
                txt="Player X Won!!"
                textbox.setText(txt)
                    clearboard()
                    break
                }
                else{
                    txt="Player Y Won!!"
                    textbox.setText(txt)
                    clearboard()
                    break
                     }

            }
        }
//checking column
        for(i in 0..2){
            if(boardstatus[0][i]==boardstatus[1][i] && boardstatus[0][i]==boardstatus[2][i] && (boardstatus[0][i]==1 || boardstatus[0][i]==0)){
                if(boardstatus[0][i]==1)
                {
                    txt="Player X Won!!"
                    textbox.setText(txt)
                    clearboard()
                    break
                }
                else{
                    txt="Player Y Won!!"
                    textbox.setText(txt)
                    clearboard()
                    break
                }

            }
        }
        //checking diagonal
        if(boardstatus[0][0]==boardstatus[1][1] && boardstatus[0][0]==boardstatus[2][2] && (boardstatus[0][0]==1 || boardstatus[0][0]==0)){
            if(boardstatus[0][0]==1)
            {
                txt="Player X Won!!"
                textbox.setText(txt)
                clearboard()
            }
            else{
                txt="Player Y Won!!"
                textbox.setText(txt)
                clearboard()
            }

        }
// checking diagonal
        if(boardstatus[2][0]==boardstatus[1][1] && boardstatus[2][0]==boardstatus[0][2] && (boardstatus[1][1]==1 || boardstatus[1][1]==0)){
            if(boardstatus[1][1]==1)
            {
                txt="Player X Won!!"
                textbox.setText(txt)
                clearboard()
            }
            else{
                txt="Player Y Won!!"
                textbox.setText(txt)
                clearboard()
            }

        }

    }

    fun clearboard(){
        for(i:Array<Button> in board){
            for (button:Button in i){
                button.isEnabled=false
            }
        }

        for(i in 0..2){
            for (j in 0..2){
                boardstatus[i][j]=-1
            }
        }
    }

    fun disablebtn(button:Button){
        button.isEnabled=false
    }

    fun resetboard(){
        for(i:Array<Button> in board){
            for (button:Button in i){
                button.isEnabled=true
                button.text=""
            }
        }

        for(i in 0..2){
            for (j in 0..2){
                boardstatus[i][j]=-1
            }
        }

        count=0
    }



}