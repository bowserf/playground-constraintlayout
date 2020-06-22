package fr.bowser.sample.constraintlayout.constraintlayout_panel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fr.bowser.sample.constraintlayout.barrier.BarrierActivity
import fr.bowser.sample.constraintlayout.circle.CircleActivity
import fr.bowser.sample.constraintlayout.databinding.ConstraintlayoutPanelFragmentBinding
import fr.bowser.sample.constraintlayout.flow.FlowActivity
import fr.bowser.sample.constraintlayout.group.GroupActivity
import fr.bowser.sample.constraintlayout.guideline.GuidelineActivity
import fr.bowser.sample.constraintlayout.linear_group.LinearGroupActivity
import fr.bowser.sample.constraintlayout.placeholder.PlaceholderActivity
import fr.bowser.sample.constraintlayout.size_percent.SizePercentActivity

class ConstraintLayoutPanelFragment : Fragment() {

    private var _binding: ConstraintlayoutPanelFragmentBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ConstraintlayoutPanelFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = activity!!

        binding.barrierBtn.setOnClickListener { BarrierActivity.startActivity(activity) }
        binding.guidelineBtn.setOnClickListener { GuidelineActivity.startActivity(activity) }
        binding.placeholderBtn.setOnClickListener { PlaceholderActivity.startActivity(activity) }
        binding.sizePercentBtn.setOnClickListener { SizePercentActivity.startActivity(activity) }
        binding.linearGroupBtn.setOnClickListener { LinearGroupActivity.startActivity(activity) }
        binding.circlePositionBtn.setOnClickListener { CircleActivity.startActivity(activity) }
        binding.groupBtn.setOnClickListener { GroupActivity.startActivity(activity) }
        binding.flowBtn.setOnClickListener { FlowActivity.startActivity(activity) }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}