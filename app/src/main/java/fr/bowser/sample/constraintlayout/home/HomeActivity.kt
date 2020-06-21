package fr.bowser.sample.constraintlayout.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.bowser.sample.constraintlayout.barrier.BarrierActivity
import fr.bowser.sample.constraintlayout.circle.CircleActivity
import fr.bowser.sample.constraintlayout.databinding.GroupActivityBinding
import fr.bowser.sample.constraintlayout.databinding.HomeActivityBinding
import fr.bowser.sample.constraintlayout.group.GroupActivity
import fr.bowser.sample.constraintlayout.guideline.GuidelineActivity
import fr.bowser.sample.constraintlayout.linear_group.LinearGroupActivity
import fr.bowser.sample.constraintlayout.placeholder.PlaceholderActivity
import fr.bowser.sample.constraintlayout.size_percent.SizePercentActivity

class HomeActivity : AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        HomeActivityBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.barrierBtn.setOnClickListener { BarrierActivity.startActivity(this) }
        binding.guidelineBtn.setOnClickListener { GuidelineActivity.startActivity(this) }
        binding.placeholderBtn.setOnClickListener { PlaceholderActivity.startActivity(this) }
        binding.sizePercentBtn.setOnClickListener { SizePercentActivity.startActivity(this) }
        binding.linearGroupBtn.setOnClickListener { LinearGroupActivity.startActivity(this) }
        binding.circlePositionBtn.setOnClickListener { CircleActivity.startActivity(this) }
        binding.groupBtn.setOnClickListener { GroupActivity.startActivity(this) }
    }
}