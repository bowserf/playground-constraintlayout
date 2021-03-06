package fr.bowser.sample.constraintlayout.motionlayout_onclick

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.bowser.sample.constraintlayout.databinding.MotionlayoutOnclickActivityBinding
import fr.bowser.sample.constraintlayout.motionlayout_autotransition.MotionLayoutAutoTransitionActivity

class MotionLayoutOnClickActivity : AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        MotionlayoutOnclickActivityBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    companion object {

        fun startActivity(context: Context) {
            val intent = Intent(context, MotionLayoutOnClickActivity::class.java)
            context.startActivity(intent)
        }
    }
}