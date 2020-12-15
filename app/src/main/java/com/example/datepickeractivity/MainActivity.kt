package com.example.datepickeractivity

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var btnCalendar: Button
    private lateinit var btnDob: Button
    private lateinit var btnOutput: Button
    private lateinit var tvWorkyear: TextView
    private lateinit var tvAge: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalendar = findViewById(R.id.btnCalendar)
        btnDob = findViewById(R.id.btnDob)
        btnOutput = findViewById(R.id.btnOutput)
        tvWorkyear = findViewById(R.id.tvWorkyear)
        tvAge = findViewById(R.id.tvAge)

        btnCalendar.setOnClickListener{
            workCalendar()
        }

        btnDob.setOnClickListener{
           dobCalendar()

        }
        val listdob = dobCalendar()
        btnOutput.setOnClickListener{

            outCalendar(listdob)
        }

    }
    private fun workCalendar(){
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener{ view, year, monthOfYear, dayOfMonth ->
                btnCalendar.text = "Date of Join: $dayOfMonth/$monthOfYear/$year"
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }

    private fun dobCalendar():List<Int>{
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener{view,year,monthOfYear, dayOfMonth ->
                btnDob.text = "DOB: $dayOfMonth/$monthOfYear/$year"
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
        val listdob = listOf<Int>(year, month, day)
        return listdob
    }

    private fun outCalendar(listdob: List<Int>){
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)
        val listdob = listdob
        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener{view,year,monthOfYear, dayOfMonth ->
                val age = year - listdob[0]
                tvAge.text = "$age"
            },
            year,
            month,
            day
        )
        datePickerDialog.show()

    }


}