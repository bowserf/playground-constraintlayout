package fr.bowser.sample.constraintlayout.motionlayout_panel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fr.bowser.sample.constraintlayout.databinding.MotionlayoutPanelFragmentBinding

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

        // TODO
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}