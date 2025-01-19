package com.rein.exploraplan.ui.budget

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.rein.exploraplan.R
import com.rein.exploraplan.databinding.FragmentAnnouncementsBinding
import com.rein.exploraplan.databinding.FragmentBudgetBinding
import com.rein.exploraplan.ui.announcements.AnnouncementsViewModel

class BudgetFragment : Fragment() {
    private var _binding: FragmentBudgetBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    /*private val viewModel: BudgetViewModel by viewModels()*/

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val budgetViewModel =
            ViewModelProvider(this).get(BudgetViewModel::class.java)

        _binding = FragmentBudgetBinding.inflate(inflater, container, false)
        val root: View = binding.root

        /*val textView: TextView = binding.textBudget
        budgetViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}