package uz.gita.lesson40.presentation.ui

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import uz.gita.lesson40.R
import uz.gita.lesson40.databinding.FragmentHomeBinding
import uz.gita.lesson40.domain.entity.getResponse.Data
import uz.gita.lesson40.presentation.HomeViewModel
import uz.gita.lesson40.presentation.adapter.CardAdapter

@AndroidEntryPoint
class Home:Fragment(R.layout.fragment_home) {
    private val biding:FragmentHomeBinding by viewBinding()
    private val viewModel:HomeViewModel by viewModels()
    private lateinit var dataList:ArrayList<Data>
    private lateinit var adapter: CardAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.getCards()
        adapter= CardAdapter()
        biding.apply {
            recycler.adapter=adapter

            addCard.setOnClickListener{
                parentFragmentManager.beginTransaction().replace(R.id.container,AddCard()).commit()
            }
            pay.setOnClickListener {
                val dialog=AlertDialog.Builder(requireContext())
                    .setTitle("Kartani ochirish")
                    .setMessage("Kartan ocirasizmi")
                    .setPositiveButton("OK",){dialog,_->
                        dataList.removeAt(dataList.size-1)
                        adapter.notifyItemRemoved(dataList.size-1)
                        adapter.notifyDataSetChanged()
                    }.show()
            }
        }
        dataList= ArrayList()
        viewLifecycleOwner.lifecycleScope.launch {

            repeatOnLifecycle(Lifecycle.State.RESUMED){
                viewModel.openSuccesFlow.collect { data ->
                dataList.addAll(data)

                    adapter.submitList(dataList)
                }
            }


            adapter.setOnClickClickListener { inex->
                val dialog=AlertDialog.Builder(requireContext())
                    .setTitle("Kartani ochirish")
                    .setMessage("Kartan ocirasizmi")
                    .setPositiveButton("OK",){dialog,_->
                        dataList.removeAt(inex)
                        adapter.submitList(dataList)
                    }.show()

            }

            repeatOnLifecycle(Lifecycle.State.RESUMED){
                viewModel.openErrorFlow.collect{error->
                    if (error==1){
                        Toast.makeText(requireContext(), "Muammoni bartaraf etish kerak ", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            repeatOnLifecycle(Lifecycle.State.RESUMED){
                viewModel.openNetworkFlow.collect{
                    Toast.makeText(requireContext(), "Internetizni yangilang", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}