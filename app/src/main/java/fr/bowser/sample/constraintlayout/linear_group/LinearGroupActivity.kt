package fr.bowser.sample.constraintlayout.linear_group

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import fr.bowser.sample.constraintlayout.R
import fr.bowser.sample.constraintlayout.databinding.LinearGroupActivityBinding


class LinearGroupActivity : AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        LinearGroupActivityBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val constraintSet = ConstraintSet()
        constraintSet.clone(binding.content.root)

        // init views
        constraintSet.setHorizontalChainStyle(
            binding.content.viewLeft.id,
            ConstraintSet.CHAIN_PACKED
        )
        constraintSet.applyTo(binding.content.root)
        binding.chainTypeChoice.check(binding.chainTypeChoicePacked.id)

        binding.chainTypeChoice.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.chain_type_choice_packed -> {
                    constraintSet.setHorizontalChainStyle(
                        binding.content.viewLeft.id,
                        ConstraintSet.CHAIN_PACKED
                    )
                    constraintSet.applyTo(binding.content.root)
                }
                R.id.chain_type_choice_spread -> {
                    constraintSet.setHorizontalChainStyle(
                        binding.content.viewLeft.id,
                        ConstraintSet.CHAIN_SPREAD
                    )
                    constraintSet.applyTo(binding.content.root)
                }
                R.id.chain_type_choice_spread_inside -> {
                    constraintSet.setHorizontalChainStyle(
                        binding.content.viewLeft.id,
                        ConstraintSet.CHAIN_SPREAD_INSIDE
                    )
                    constraintSet.applyTo(binding.content.root)
                }
            }
        }
    }

    companion object {

        fun startActivity(context: Context) {
            val intent = Intent(context, LinearGroupActivity::class.java)
            context.startActivity(intent)
        }
    }
}