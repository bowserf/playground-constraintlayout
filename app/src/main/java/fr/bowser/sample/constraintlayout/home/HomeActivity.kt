package fr.bowser.sample.constraintlayout.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.google.android.material.tabs.TabLayoutMediator
import fr.bowser.sample.constraintlayout.constraintlayout_panel.ConstraintLayoutPanelFragment
import fr.bowser.sample.constraintlayout.databinding.HomeActivityBinding
import fr.bowser.sample.constraintlayout.motionlayout_panel.MotionLayoutPanelFragment

class HomeActivity : AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        HomeActivityBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.viewPager.adapter = ModeAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> "ConstraintLayout"
                1 -> "MotionLayout"
                else -> throw Exception("Not managed mode position: $position")
            }
        }.attach()

    }

    class ModeAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

        override fun getItemCount(): Int = 2

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> ConstraintLayoutPanelFragment()
                1 -> MotionLayoutPanelFragment()
                else -> throw Exception("Not managed mode position: $position")
            }
        }
    }
}