package fr.bowser.sample.constraintlayout.size_percent

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import fr.bowser.sample.constraintlayout.databinding.SizepercentActivityBinding
import fr.bowser.sample.constraintlayout.utils.SeekBarChangeListener

class SizePercentActivity : AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        SizepercentActivityBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.sliderWidth.max = 100
        binding.sliderHeight.max = 100

        val constraintLP =
            binding.content.resizedColoredView.layoutParams as ConstraintLayout.LayoutParams

        val currentSliderWidthProgress =
            constraintLP.matchConstraintPercentWidth * binding.sliderWidth.max
        binding.sliderWidth.progress = currentSliderWidthProgress.toInt()

        val currentSliderHeightProgress =
            constraintLP.matchConstraintPercentHeight * binding.sliderWidth.max
        binding.sliderHeight.progress = currentSliderHeightProgress.toInt()

        binding.sliderWidth.setOnSeekBarChangeListener(object : SeekBarChangeListener() {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                val percent = progress / seekBar.max.toFloat()
                constraintLP.matchConstraintPercentWidth = percent
                binding.content.resizedColoredView.requestLayout()
            }
        })

        binding.sliderHeight.setOnSeekBarChangeListener(object : SeekBarChangeListener() {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                val percent = progress / seekBar.max.toFloat()
                constraintLP.matchConstraintPercentHeight = percent
                binding.content.resizedColoredView.requestLayout()
            }
        })
    }

    companion object {

        fun startActivity(context: Context) {
            val intent = Intent(context, SizePercentActivity::class.java)
            context.startActivity(intent)
        }
    }
}