package fr.bowser.sample.constraintlayout.layer

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import fr.bowser.sample.constraintlayout.databinding.LayerActivityBinding

class LayerActivity : AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        LayerActivityBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        // set rotation to 0 to fix animation computation in ConstraintLayout 2.0.0
        binding.content.layer.rotation = 0f

        binding.playAnimation.setOnCheckedChangeListener { _, isChecked ->
            val startValue = if (isChecked) 0f else 100f
            val endValue = if (isChecked) 100f else 0f
            val animator = ObjectAnimator.ofFloat(startValue, endValue)
            animator.addUpdateListener(createBottomContainerAnimationListener())
            animator.start()
        }

        binding.changeLayerVisibility.setOnCheckedChangeListener { _, isChecked ->
            binding.content.layer.visibility = if (isChecked) View.GONE else View.VISIBLE
        }
    }

    private fun createBottomContainerAnimationListener() =
        ValueAnimator.AnimatorUpdateListener { animation ->
            val translationY = animation.animatedValue as Float
            binding.content.layer.translationY = translationY
        }

    companion object {

        fun startActivity(context: Context) {
            val intent = Intent(context, LayerActivity::class.java)
            context.startActivity(intent)
        }
    }
}