package com.lrm.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.Toast
import com.lrm.tictactoe.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    var player = "p1"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            box1.setOnClickListener { buttonClick(box1) }
            box2.setOnClickListener { buttonClick(box2) }
            box3.setOnClickListener { buttonClick(box3) }
            box4.setOnClickListener { buttonClick(box4) }
            box5.setOnClickListener { buttonClick(box5) }
            box6.setOnClickListener { buttonClick(box6) }
            box7.setOnClickListener { buttonClick(box7) }
            box8.setOnClickListener { buttonClick(box8) }
            box9.setOnClickListener { buttonClick(box9) }
        }

        binding.resetButton.setOnClickListener { resetGame() }
    }

    fun buttonClick(btn: Button) {

        val myAnim: Animation = AnimationUtils.loadAnimation(this, R.anim.bounce)
        val interpolator = MyBounceInterpolator(0.2, 20.0)
        myAnim.interpolator = interpolator

        if (btn.text == "") {
            if (player == "p1") {
                btn.background = resources.getDrawable(R.drawable.x_icon)
                btn.text = resources.getString(R.string.x)
                player = "p2"
                btn.isClickable = false
                btn.startAnimation(myAnim)
            } else {
                btn.background = resources.getDrawable(R.drawable.o_icon)
                btn.text = resources.getString(R.string.o)
                player = "p1"
                btn.isClickable = false
                btn.startAnimation(myAnim)
            }
        }

        win()
    }

    fun win() {
        val x = resources.getString(R.string.x)
        val o = resources.getString(R.string.o)

        binding.apply {
            if ((box1.text == x && box2.text == x && box3.text == x) ||
                (box4.text == x && box5.text == x && box6.text == x) ||
                (box7.text == x && box8.text == x && box9.text == x) ||
                (box1.text == x && box4.text == x && box7.text == x) ||
                (box2.text == x && box5.text == x && box8.text == x) ||
                (box3.text == x && box6.text == x && box9.text == x) ||
                (box1.text == x && box5.text == x && box9.text == x) ||
                (box3.text == x && box5.text == x && box7.text == x)
            ) {
                tvResult.text = "X won the game"
                Toast.makeText(this@MainActivity, "X won the game", Toast.LENGTH_SHORT).show()
                disableButton()
            } else if ((box1.text == o && box2.text == o && box3.text == o) ||
                (box4.text == o && box5.text == o && box6.text == o) ||
                (box7.text == o && box8.text == o && box9.text == o) ||
                (box1.text == o && box4.text == o && box7.text == o) ||
                (box2.text == o && box5.text == o && box8.text == o) ||
                (box3.text == o && box6.text == o && box9.text == o) ||
                (box1.text == o && box5.text == o && box9.text == o) ||
                (box3.text == o && box5.text == o && box7.text == o)
            ) {
                tvResult.text = "O won the game"
                Toast.makeText(this@MainActivity, "O won the game", Toast.LENGTH_SHORT).show()
                disableButton()
            } else if(box1.text != "" && box2.text != "" && box3.text != "" && box4.text != "" && box5.text != "" &&
                box6.text != "" && box7.text != "" && box8.text != "" && box9.text != "") {
                tvResult.text = "Match Draw"
                Toast.makeText(this@MainActivity, "It's a Tie...Play again...", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun disableButton() {
        binding.apply {
            box1.isClickable = false
            box2.isClickable = false
            box3.isClickable = false
            box4.isClickable = false
            box5.isClickable = false
            box6.isClickable = false
            box7.isClickable = false
            box8.isClickable = false
            box9.isClickable = false
        }
    }

    fun resetGame() {
        binding.apply {
            box1.isClickable = true
            box2.isClickable = true
            box3.isClickable = true
            box4.isClickable = true
            box5.isClickable = true
            box6.isClickable = true
            box7.isClickable = true
            box8.isClickable = true
            box9.isClickable = true

            box1.background = resources.getDrawable(R.drawable.box_icon)
            box2.background = resources.getDrawable(R.drawable.box_icon)
            box3.background = resources.getDrawable(R.drawable.box_icon)
            box4.background = resources.getDrawable(R.drawable.box_icon)
            box5.background = resources.getDrawable(R.drawable.box_icon)
            box6.background = resources.getDrawable(R.drawable.box_icon)
            box7.background = resources.getDrawable(R.drawable.box_icon)
            box8.background = resources.getDrawable(R.drawable.box_icon)
            box9.background = resources.getDrawable(R.drawable.box_icon)

            box1.text = ""
            box2.text = ""
            box3.text = ""
            box4.text = ""
            box5.text = ""
            box6.text = ""
            box7.text = ""
            box8.text = ""
            box9.text = ""

            tvResult.text = ""

            player = "p1"
        }
    }
}