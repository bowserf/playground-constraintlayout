package fr.bowser.sample.constraintlayout.barrier

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import fr.bowser.sample.constraintlayout.databinding.BarrierActivityBinding
import fr.bowser.sample.constraintlayout.utils.SeekBarChangeListener

class BarrierActivity : AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        BarrierActivityBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.sliderMovingWidthView.max = 100

        setCurrentSliderProgress()

        binding.sliderMovingWidthView.setOnSeekBarChangeListener(object : SeekBarChangeListener() {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                val percent = progress / seekBar.max.toFloat()
                binding.content.verticalGuide.setGuidelinePercent(percent)
            }
        })
    }

    private fun setCurrentSliderProgress() {
        val constraintLP =
            binding.content.verticalGuide.layoutParams as ConstraintLayout.LayoutParams
        val currentSliderProgress = constraintLP.guidePercent * binding.sliderMovingWidthView.max
        binding.sliderMovingWidthView.progress = currentSliderProgress.toInt()
    }

    companion object {

        fun startActivity(context: Context) {
            val intent = Intent(context, BarrierActivity::class.java)
            context.startActivity(intent)
        }
    }
}