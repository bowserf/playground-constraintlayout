package fr.bowser.sample.constraintlayout.guideline

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Guideline
import fr.bowser.sample.constraintlayout.databinding.GuidelineActivityBinding
import fr.bowser.sample.constraintlayout.utils.SeekBarChangeListener

class GuidelineActivity : AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        GuidelineActivityBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.sliderHorizontalGuide.max = 100
        binding.sliderVerticalGuide.max = 100

        setCurrentSliderProgress(binding.content.horizontalGuide, binding.sliderHorizontalGuide)
        setCurrentSliderProgress(binding.content.verticalGuide, binding.sliderVerticalGuide)

        binding.sliderHorizontalGuide.setOnSeekBarChangeListener(object : SeekBarChangeListener() {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                val percent = progress / seekBar.max.toFloat()
                binding.content.horizontalGuide.setGuidelinePercent(percent)
            }
        })

        binding.sliderVerticalGuide.setOnSeekBarChangeListener(object : SeekBarChangeListener() {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                val percent = progress / seekBar.max.toFloat()
                binding.content.verticalGuide.setGuidelinePercent(percent)
            }
        })
    }

    private fun setCurrentSliderProgress(guide: Guideline, seekBar: SeekBar) {
        val constraintLP = guide.layoutParams as ConstraintLayout.LayoutParams
        val currentSliderProgress = constraintLP.guidePercent * seekBar.max
        seekBar.progress = currentSliderProgress.toInt()
    }

    companion object {

        fun startActivity(context: Context) {
            val intent = Intent(context, GuidelineActivity::class.java)
            context.startActivity(intent)
        }
    }
}