package uz.gita.lesson40.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import uz.gita.lesson40.R
import uz.gita.lesson40.databinding.HistoryFragmentBinding
import uz.gita.lesson40.presentation.HistoryViewModel
import uz.gita.lesson40.presentation.adapter.HistoryAdapter

@AndroidEntryPoint
class HistoryFragment : Fragment(R.layout.history_fragment) {
    private val binding: HistoryFragmentBinding by viewBinding()
    private val viewModel : HistoryViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.history()
        val adapter = HistoryAdapter()
        binding.recycler.adapter =adapter
        lifecycleScope.launch {
            viewModel.openErrorFlow.collect {

            }
        }
        lifecycleScope.launch {
            viewModel.openSuccessScreenFlow.collect {data ->
                adapter.submitList(data.reversed())
            }
        }
        lifecycleScope.launch {
            viewModel.openNetworkFlow.collect {

            }
        }
    }
}
