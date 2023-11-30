package uz.gita.lesson40.presentation.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.SnapHelper
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.lesson40.R
import uz.gita.lesson40.databinding.FagmentUpdateBinding
import uz.gita.lesson40.domain.entity.getResponse.Data
import uz.gita.lesson40.presentation.adapter.CardAdapter

class RenameFragment : Fragment(R.layout.fagment_update) {
    private val binding: FagmentUpdateBinding by viewBinding()
    private val adapter by lazy { CardAdapter() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val currentTheme = arguments?.getInt("src")
        binding.recycler.adapter = adapter
        adapter.submitList(
            listOf(
                Data(
                    0,
                    "100000",
                    2,
                    30,
                    0,
                    "Noman Manzoor",
                    "9860228412344567",
                    "+998941234567",
                    R.drawable.group_2
                ),
                Data(
                    0,
                    "100000",
                    2,
                    30,
                    0,
                    "Noman Manzoor",
                    "9860228412344567",
                    "+998941234567",
                    R.drawable.group_4
                ),
                Data(
                    0,
                    "100000",
                    2,
                    30,
                    0,
                    "Noman Manzoor",
                    "9860228412344567",
                    "+998941234567",
                    R.drawable.group_5
                ),
                Data(
                    0,
                    "100000",
                    2,
                    30,
                    0,
                    "Noman Manzoor",
                    "9860228412344567",
                    "+998941234567",
                    R.drawable.card_back
                ),
            )
        )
        for (i in 0 until adapter.currentList.size){
            if (adapter.currentList[i].theme == currentTheme) {
                binding.recycler.layoutManager?.scrollToPosition(i)
                return
            }
        }
        val snapHelper: SnapHelper = LinearSnapHelper()
        snapHelper.attachToRecyclerView(binding.recycler)
    }
}