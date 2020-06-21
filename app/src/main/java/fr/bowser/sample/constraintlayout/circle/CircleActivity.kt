package fr.bowser.sample.constraintlayout.circle

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.SeekBar
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import fr.bowser.sample.constraintlayout.databinding.CircleActivityBinding
import fr.bowser.sample.constraintlayout.utils.SeekBarChangeListener

class CircleActivity : AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        CircleActivityBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.sliderAngle.max = 360
        binding.sliderRadius.max = 150
        binding.sliderRadius.progress = 100

        val constraintLP =
            binding.content.circlePositionView.layoutParams as ConstraintLayout.LayoutParams

        constraintLP.circleRadius = binding.sliderRadius.progress
        constraintLP.circleAngle = binding.sliderAngle.progress.toFloat()
        binding.content.circlePositionView.requestLayout()

        binding.sliderRadius.setOnSeekBarChangeListener(object : SeekBarChangeListener() {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                constraintLP.circleRadius = progress
                binding.content.circlePositionView.requestLayout()
            }
        })

        binding.sliderAngle.setOnSeekBarChangeListener(object : SeekBarChangeListener() {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                constraintLP.circleAngle = progress.toFloat()
                binding.content.circlePositionView.requestLayout()
            }
        })
    }

    companion object {

        fun startActivity(context: Context) {
            val intent = Intent(context, CircleActivity::class.java)
            context.startActivity(intent)
        }
    }
}