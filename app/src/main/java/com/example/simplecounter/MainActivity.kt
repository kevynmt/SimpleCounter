package com.example.simplecounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var numClicks = 0               //The number of times the user has clicked the button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Create the views for the buttons
        val button = findViewById<Button>(R.id.button)                  //Button that increases the counter
        val upgradeButton = findViewById<Button>(R.id.upgradeButton)    //Button that upgrades clicks

        //Create the view for the textView
        val textView = findViewById<TextView>(R.id.textView)

        //When the button is clicked, add the specified amount to numClicks and update the textView
        button.setOnClickListener{
            numClicks++
            textView.text = numClicks.toString()

            //If numClicks is 100, make the upgrade button visible
            if (numClicks >= 100)
            {
                //Show the upgrade button and set an onClickListener for it
                upgradeButton.visibility = View.VISIBLE
                upgradeButton.setOnClickListener {
                    button.text = "Add 2"

                    //Update the button so that it adds 2 to the counter instead of 1
                    button.setOnClickListener {
                        numClicks += 2
                        textView.text = numClicks.toString()
                    }

                    //Make the upgrade button invisible again
                    upgradeButton.visibility = View.INVISIBLE
                }
            }

            //This code does absolutely nothing. Please ignore
            if (numClicks == 999)
            {
                Toast.makeText(it.context, "You're gay! :D", Toast.LENGTH_SHORT).show()
            }
        }
    }
}