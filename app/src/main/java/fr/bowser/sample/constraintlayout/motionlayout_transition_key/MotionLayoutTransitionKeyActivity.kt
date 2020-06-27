package fr.bowser.sample.constraintlayout.motionlayout_transition_key

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import fr.bowser.sample.constraintlayout.databinding.MotionlayoutTransitionKeyActivityBinding

class MotionLayoutTransitionKeyActivity : AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        MotionlayoutTransitionKeyActivityBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    companion object {

        fun startActivity(context: Context) {
            val intent = Intent(context, MotionLayoutTransitionKeyActivity::class.java)
            context.startActivity(intent)
        }
    }
}