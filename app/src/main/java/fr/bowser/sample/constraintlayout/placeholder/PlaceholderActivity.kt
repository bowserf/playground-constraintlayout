package fr.bowser.sample.constraintlayout.placeholder

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.bowser.sample.constraintlayout.R
import fr.bowser.sample.constraintlayout.databinding.PlaceholderActivityBinding

class PlaceholderActivity : AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        PlaceholderActivityBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.moveTextBtn.setOnClickListener {
            if (binding.content.placeholderStart.content == null) {
                binding.content.placeholderEnd.setContentId(0)
                binding.content.placeholderStart.setContentId(binding.content.movingText.id)
                binding.content.movingText.text = "Set in START placeholder"
            } else {
                binding.content.placeholderStart.setContentId(0)
                binding.content.placeholderEnd.setContentId(binding.content.movingText.id)
                binding.content.movingText.text = "Set in END placeholder"
            }
        }
    }

    companion object {

        fun startActivity(context: Context) {
            val intent = Intent(context, PlaceholderActivity::class.java)
            context.startActivity(intent)
        }
    }
}