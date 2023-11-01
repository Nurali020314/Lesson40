package uz.gita.lesson40.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.lesson40.R
import uz.gita.lesson40.databinding.FragmentHomeBinding
import uz.gita.lesson40.domain.entity.CardEntity
import uz.gita.lesson40.presentation.adapter.CardAdapter

class Home:Fragment(R.layout.fragment_home) {
    private val binding: FragmentHomeBinding by viewBinding()
    private val adapter by lazy { CardAdapter() }
    private lateinit var recycler: RecyclerView
    private val data by lazy { ArrayList<CardEntity>() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recycler = binding.recycler
        data.addAll(listOf(CardEntity(5000, 1), CardEntity(6000, 2)))
        adapter.submitList(data)
        recycler.adapter = adapter
    }

}