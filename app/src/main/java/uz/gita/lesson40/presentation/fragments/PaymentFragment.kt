package uz.gita.lesson40.presentation.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import uz.gita.lesson40.R
import uz.gita.lesson40.databinding.FragmentPaymentBinding
import uz.gita.lesson40.domain.entity.Data
import uz.gita.lesson40.domain.entity.Type
import uz.gita.lesson40.presentation.PaymentViewModel
import uz.gita.lesson40.presentation.adapter.PaymentAdapter

@AndroidEntryPoint
class PaymentFragment : Fragment(R.layout.fragment_payment) {

    private val binding: FragmentPaymentBinding by viewBinding()
    private val adapter by lazy { PaymentAdapter() }
    private val viewModel: PaymentViewModel by viewModels()
    private val list = ArrayList<Type>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recycler.adapter = adapter
        binding.back.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.openErrorFlow.collect {

            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.openSuccessScreenFlow.collect { data ->
                list.clear()
                list.addAll(data.first().types)
                adapter.submitList(list)
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.openNetworkFlow.collect {
                Toast.makeText(requireContext(), "No Network", Toast.LENGTH_SHORT).show()
            }
        }
    }
}