package com.example.datepickeractivity

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var btnCalendar:Button
    private lateinit var btnDob : Button
    private lateinit var btnOutput : Button
    private lateinit var tvWorkyear : TextView
    private lateinit var tvAge : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalendar = findViewById(R.id.btnCalendar)
        btnDob = findViewById(R.id.btnDob)
        btnOutput=findViewById(R.id.btnOutput)
        tvWorkyear=findViewById(R.id.tvWorkyear)
        tvAge=findViewById(R.id.tvAge)

        btnCalendar.setOnClickListener{
            loadCalender()
        }
        btnDob.setOnClickListener{
            loaddob()
        }

    }
    private fun loadCalender(){
        val c = Calendar.getInstance()
        val year1 = c.get(Calendar.YEAR)
        val month1 = c. get(Calendar.MONTH)
        val day1 = c.get(Calendar.DATE)

        val datePickerDialog=DatePickerDialog(
                this, DatePickerDialog.OnDateSetListener { view, year, month, day ->
            btnCalendar.text = "$year/$month/$day"
            tvWorkyear.text = " ${year1-year}-${month1-(month)}"

        },
                year1,
                month1,
                day1

        )
        datePickerDialog.show()
    }
    private fun loaddob(){
        val c = Calendar.getInstance()
        val year1 = c.get(Calendar.YEAR)
        val month1 = c. get(Calendar.MONTH)
        val day1 = c.get(Calendar.DATE)

        val datePickerDialog=DatePickerDialog(
                this, DatePickerDialog.OnDateSetListener { view, year, month, day ->
            btnDob.setText("$year:$month:$day")
            tvAge.setText("${year1-year}-${month1-(month)}")

        },
                year1,
                month1,
                day1

        )
        datePickerDialog.show()
    }

}