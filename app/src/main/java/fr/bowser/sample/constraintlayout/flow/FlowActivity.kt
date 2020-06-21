package fr.bowser.sample.constraintlayout.flow

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.helper.widget.Flow
import fr.bowser.sample.constraintlayout.databinding.FlowActivityBinding

class FlowActivity : AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        FlowActivityBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.flowWrapMode.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                binding.flowWrapModeNone.id -> {
                    binding.content.flow.setWrapMode(Flow.WRAP_NONE)
                }
                binding.flowWrapModeChain.id -> {
                    binding.content.flow.setWrapMode(Flow.WRAP_CHAIN)
                }
                binding.flowWrapModeSpreadAligned.id -> {
                    binding.content.flow.setWrapMode(Flow.WRAP_ALIGNED)
                }
            }
        }

        binding.flowHorizontalStyle.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                binding.flowHorizontalStylePacked.id -> {
                    binding.content.flow.setHorizontalStyle(Flow.CHAIN_PACKED)
                }
                binding.flowHorizontalStyleSpread.id -> {
                    binding.content.flow.setHorizontalStyle(Flow.CHAIN_SPREAD)
                }
                binding.flowHorizontalStyleSpreadInside.id -> {
                    binding.content.flow.setHorizontalStyle(Flow.CHAIN_SPREAD_INSIDE)
                }
            }
        }

        binding.flowVerticalAlign.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                binding.flowVerticalAlignTop.id -> {
                    binding.content.flow.setVerticalAlign(Flow.VERTICAL_ALIGN_TOP)
                }
                binding.flowVerticalAlignCenter.id -> {
                    binding.content.flow.setVerticalAlign(Flow.VERTICAL_ALIGN_CENTER)
                }
                binding.flowVerticalAlignBottom.id -> {
                    binding.content.flow.setVerticalAlign(Flow.VERTICAL_ALIGN_BOTTOM)
                }
            }
        }

        binding.flowWrapMode.check(binding.flowWrapModeNone.id)
        binding.flowHorizontalStyle.check(binding.flowHorizontalStyleSpread.id)
        binding.flowVerticalAlign.check(binding.flowVerticalAlignCenter.id)
    }

    companion object {

        fun startActivity(context: Context) {
            val intent = Intent(context, FlowActivity::class.java)
            context.startActivity(intent)
        }
    }
}