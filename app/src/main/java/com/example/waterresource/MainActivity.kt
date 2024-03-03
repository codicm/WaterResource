package com.example.waterresource

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private lateinit var waterResourceEditText: EditText
    private lateinit var locationEditText: EditText
    private lateinit var typeEditText: EditText
    private lateinit var tableRow: TableRow
    private lateinit var tableLayout: TableLayout
//    private lateinit var cellRow1:

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var adding = findViewById<Button>(R.id.addbtn)

        waterResourceEditText = findViewById(R.id.Text1)
        locationEditText = findViewById(R.id.Text2)
        typeEditText = findViewById(R.id.Text3)


        adding.setOnClickListener {
            //check whether all EditText has some content
            if (waterResourceEditText.text.toString().isNullOrBlank()) {
                Toast.makeText(this, "Water Resource Field should not be empty", Toast.LENGTH_LONG)
                    .show()
            } else if (typeEditText .text.toString().isNullOrBlank()) {
                Toast.makeText(this, "TYPE Field should not be empty", Toast.LENGTH_LONG).show()
            } else if (locationEditText.text.toString().isNullOrBlank()) {
                Toast.makeText(this, "Location Field should not be empty", Toast.LENGTH_LONG).show()
            }
            //read data frem EditText(s) and do the rest
            else {

                addRowToTable()

                // Clear EditText fields after adding a row
                waterResourceEditText.text.clear()
                locationEditText.text.clear()
                typeEditText.text.clear()
            }
        }
    }


    private fun addRowToTable() {
//        tableRow = findViewById(R.id.row2)
//        cellRow1 = findViewById(/R.id.cell1)
//        val row = row2Main(this)
        tableLayout=findViewById(R.id.tablelayoutid)
        tableRow = TableRow(this)
        // Create TextView for Resource Name
        val waterResourceTextView = TextView(this)
        waterResourceTextView.text = waterResourceEditText.text
        //resourceNameTextView.setBackgroundResource(R.drawable.line_drawable)
        waterResourceTextView.setPadding(10, 10, 10, 10)
        tableRow.addView(waterResourceTextView)

        // Create TextView for Location
        val locationTextView = TextView(this)
        locationTextView.text = locationEditText.text
        // locationTextView.setBackgroundResource(R.drawable.line_drawable)
        locationTextView.setPadding(10, 10, 10, 10)
        tableRow.addView(locationTextView)

        // Create TextView for Type
        val typeTextView = TextView(this)
        typeTextView.text = typeEditText.text
        //typeTextView.setBackgroundResource(R.drawable.line_drawable)
        typeTextView.setPadding(10, 10, 10, 10)
        tableRow.addView(typeTextView)

        // Add the new row to the table
        tableLayout.addView(tableRow)
    }
}