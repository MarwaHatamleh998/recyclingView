package com.example.recyclingguide

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview.R

class MainActivity : AppCompatActivity() {

    private val wasteTypes = arrayOf("plastic", "paper", "glass")

    private val wasteDescriptions = arrayOf(
        "Plastic can be recycled. Clean it before disposal.",
        "Paper is recyclable. Keep it dry and clean.",
        "Glass is highly recyclable. Separate by color if possible."
    )

    private val wasteImages = arrayOf<Int>(
        R.drawable.plastic,
        R.drawable.paper,
        R.drawable.glass
    )

    private val defaultImage = R.drawable.ic_default

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etWaste = findViewById<EditText>(R.id.etWaste)
        val btnCheck = findViewById<Button>(R.id.btnCheck)
        val tvResult = findViewById<TextView>(R.id.tvResult)
        val imgWaste = findViewById<ImageView>(R.id.imgWaste)

        btnCheck.setOnClickListener {

            val input = etWaste.text.toString().trim().lowercase()

            var foundIndex = -1

            for (i in wasteTypes.indices) {
                if (wasteTypes[i].contains(input)) {
                    foundIndex = i
                    break
                }
            }

            if (foundIndex != -1) {
                tvResult.text = wasteDescriptions[foundIndex]
                imgWaste.setImageResource(wasteImages[foundIndex])
            } else {
                tvResult.text = "Item not found"
                imgWaste.setImageResource(defaultImage)
            }
        }
    }
}