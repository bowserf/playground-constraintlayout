package fr.bowser.sample.constraintlayout.group

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import fr.bowser.sample.constraintlayout.databinding.GroupActivityBinding

class GroupActivity : AppCompatActivity() {

    private val binding by lazy(LazyThreadSafetyMode.NONE) {
        GroupActivityBinding.inflate(
            layoutInflater
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.changeGroupVisibility.setOnCheckedChangeListener { _, isChecked ->
            binding.content.group.visibility = if (isChecked) View.GONE else View.VISIBLE
        }
    }

    companion object {

        fun startActivity(context: Context) {
            val intent = Intent(context, GroupActivity::class.java)
            context.startActivity(intent)
        }
    }
}