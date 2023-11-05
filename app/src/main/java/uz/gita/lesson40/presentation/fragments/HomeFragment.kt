package uz.gita.lesson40.presentation.fragments

import android.app.AlertDialog
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
import uz.gita.lesson40.databinding.FragmentHomeBinding
import uz.gita.lesson40.domain.entity.getResponse.Data
import uz.gita.lesson40.presentation.HomeViewModel
import uz.gita.lesson40.presentation.adapter.CardAdapter

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private val biding: FragmentHomeBinding by viewBinding()
    private val viewModel: HomeViewModel by viewModels()
    private val dataList: ArrayList<Data> by lazy { ArrayList() }
    private val adapter by lazy { CardAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        biding.apply {
            recycler.adapter = adapter

            addCard.setOnClickListener {
                parentFragmentManager.beginTransaction().setReorderingAllowed(true)
                    .addToBackStack("HomeFragment").replace(R.id.container, AddCardFragment()).commit()
            }
            pay.setOnClickListener {
                parentFragmentManager.beginTransaction().setReorderingAllowed(true)
                    .addToBackStack("HomeFragment").replace(R.id.container, TransferFragment()).commit()
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.openSuccesFlow.collect { data ->
                dataList.clear()
                dataList.addAll(data)
                adapter.submitList(dataList)
            }
        }
        adapter.setOnClickClickListener { inex ->
            val dialog = AlertDialog.Builder(requireContext())
                .setTitle("Deleting Card")
                .setMessage("Are you sure?")
                .setPositiveButton("Yes") { dialog, _ ->
                    dataList.removeAt(inex)
                    adapter.submitList(dataList)
                }.show()
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.openErrorFlow.collect { error ->
                if (error == 1) {
                    Toast.makeText(
                        requireContext(),
                        "Something went wrong",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.openNetworkFlow.collect {
                Toast.makeText(requireContext(), "No Network", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}