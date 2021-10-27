package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton:Button= findViewById(R.id.button)
        rollButton.setOnClickListener { rollDice() }

// To add random dice image on startup of the app
        rollDice()
    }
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()
        val diceImage : ImageView = findViewById(R.id.imageView)

        diceImage.contentDescription = diceRoll.toString()

        val diceResult = when (diceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(diceResult)
    }

    class Dice(private val numSides : Int){
        fun roll():Int {
            return (1..numSides).random()
        }
    }
}