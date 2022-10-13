package com.example.ageindays

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.ageindays.databinding.ActivityMainBinding
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    lateinit var bind :ActivityMainBinding
    private var  a=0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        
        bind.clear.setOnClickListener{bind.InAge.setText("")}


        bind.daysCal.setOnClickListener{

            responseButton(bind.InAge.text.toString(),"Days")

        }
        bind.hourscal.setOnClickListener{
            responseButton(bind.InAge.text.toString(),"Hours")

        }
        bind.minCal.setOnClickListener{
            responseButton(bind.InAge.text.toString(),"Mins")
        }}

    fun responseButton(a:String, strBtn:String)
    {
        if (a!="") {
            var num = a.toDouble()
            var showOut = ""
            when (strBtn) {
                "Days" -> {
                    num *= 365
                    showOut = "You have lived $num Days till now"
                }

                "Hours" -> {
                    num *= ((num * 365) * 24)

                    showOut = "You have lived $num Hours till now"
                }
                "Mins" -> {
                    num = (((num * 365) * 24) * 60)

                    showOut = "You have lived $num Minutes till now"
                }


            }
            bind.InAge.setText(showOut)
        }

        else
            Toast.makeText(this,"Please enter some value",Toast.LENGTH_SHORT).show()


    }
}