package fr.bowser.sample.constraintlayout.motionlayout_panel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fr.bowser.sample.constraintlayout.databinding.MotionlayoutPanelFragmentBinding
import fr.bowser.sample.constraintlayout.motionlayout_onswipe.MotionLayoutOnSwipeActivity
import fr.bowser.sample.constraintlayout.motionlayout_transition_key.MotionLayoutTransitionKeyActivity

class MotionLayoutPanelFragment : Fragment() {

    private var _binding: MotionlayoutPanelFragmentBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = MotionlayoutPanelFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = activity!!

        binding.onswipeBtn.setOnClickListener { MotionLayoutOnSwipeActivity.startActivity(activity) }
        binding.keyPositionAttributeBtn.setOnClickListener {
            MotionLayoutTransitionKeyActivity.startActivity(
                activity
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}