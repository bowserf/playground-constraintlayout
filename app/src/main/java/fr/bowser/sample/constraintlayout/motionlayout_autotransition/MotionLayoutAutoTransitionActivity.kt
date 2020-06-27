package fr.bowser.sample.constraintlayout.motionlayout_autotransition

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.bowser.sample.constraintlayout.databinding.MotionlayoutAutoTransitionActivityBinding

class MotionLayoutAutoTransitionActivity : AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        MotionlayoutAutoTransitionActivityBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    companion object {

        fun startActivity(context: Context) {
            val intent = Intent(context, MotionLayoutAutoTransitionActivity::class.java)
            context.startActivity(intent)
        }
    }
}