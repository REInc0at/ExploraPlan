package com.rein.exploraplan.ui.announcements

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.rein.exploraplan.databinding.FragmentAnnouncementsBinding

class AnnouncementsFragment : Fragment() {

    private var _binding: FragmentAnnouncementsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val announcementsViewModel =
            ViewModelProvider(this).get(AnnouncementsViewModel::class.java)

        _binding = FragmentAnnouncementsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textAnnouncement
        announcementsViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}