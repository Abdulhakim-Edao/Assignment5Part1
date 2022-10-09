package com.example.assignment5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        submit.setOnClickListener{
            val c = Calendar.getInstance()
            var date = c.get(Calendar.DAY_OF_MONTH)
            var month = c.get(Calendar.MONTH)+1
            var year = c.get(Calendar.YEAR)
            var time = c.get(Calendar.HOUR)
            var min = c.get(Calendar.MINUTE)
            var sec = c.get(Calendar.SECOND)
            var score = 0
            if(radioButton1.isChecked){
                score += 50
            }
            if(checkBox1.isChecked && checkBox2.isChecked && checkBox3.isChecked){
                score += 50
            }
            var myDialog = AlertDialog.Builder(this)
            myDialog.setTitle("Quiz Submitted")
            if(score>=50){
                myDialog.setMessage("Congratulations! You submitted on $month/$date/$year, at $time:$min:$sec, You achieved $score%")
            }
            else{
                myDialog.setMessage("You scored $score")
            }

            myDialog.setPositiveButton("Done"){dialogInterface, which ->
                dialogInterface.dismiss()
                finish()
            }

            myDialog.setNegativeButton("Retake"){dialogInterface, which->
                dialogInterface.dismiss()
                radioButton1.isChecked = false
                radioButton2.isChecked = false
                radioButton3.isChecked = false
                checkBox1.isChecked = false
                checkBox2.isChecked = false
                checkBox3.isChecked = false
            }

            val dialog:AlertDialog = myDialog.create()
            dialog.show()

        }

        reset.setOnClickListener{
            radioButton1.isChecked = false
            radioButton2.isChecked = false
            radioButton3.isChecked = false
            checkBox1.isChecked = false
            checkBox2.isChecked = false
            checkBox3.isChecked = false
        }
    }
}