package com.example.xocdia

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val resultTextView: TextView = findViewById(R.id.textViewNumber)
        val rollButton: Button = findViewById(R.id.buttonRoll)
        rollButton.setOnClickListener {
            val image: ImageView = findViewById(R.id.imageView)
            val randomNumber = rollDice()
            resultTextView.text = randomNumber.toString()
            when(randomNumber){
                1->{
                    Toast.makeText(this,"You got Daddy", Toast.LENGTH_SHORT).show()
                    image.setImageResource(R.drawable.diluc)
                }
                2->{
                    Toast.makeText(this,"You got Fischl", Toast.LENGTH_SHORT).show()
                    image.setImageResource(R.drawable.fischl)
                }
                3->{
                    Toast.makeText(this,"You got a Terrorist", Toast.LENGTH_SHORT).show()
                    image.setImageResource(R.drawable.klee)
                }
                4->{
                    Toast.makeText(this,"You got a cute zombie", Toast.LENGTH_SHORT).show()
                    image.setImageResource(R.drawable.qiqi)
                }
                5->{
                    Toast.makeText(this,"You got MONA", Toast.LENGTH_SHORT).show()
                    image.setImageResource(R.drawable.mona)
                }
                6->{
                    Toast.makeText(this,"You got Succrose", Toast.LENGTH_SHORT).show()
                    image.setImageResource(R.drawable.succrose)
                }
            }
        }

    }

    private fun rollDice(): Int {
        val dice = Dice(6)
        return dice.roll()
    }
}

class Dice(private val numSides: Int){
    fun roll():Int{
        return (1..numSides).random()
    }
}