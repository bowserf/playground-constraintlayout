package fr.bowser.sample.constraintlayout.motionlayout_onswipe

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.bowser.sample.constraintlayout.databinding.MotionlayoutOnswipeActivityBinding

class MotionLayoutOnSwipeActivity : AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        MotionlayoutOnswipeActivityBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    companion object {

        fun startActivity(context: Context) {
            val intent = Intent(context, MotionLayoutOnSwipeActivity::class.java)
            context.startActivity(intent)
        }
    }
}