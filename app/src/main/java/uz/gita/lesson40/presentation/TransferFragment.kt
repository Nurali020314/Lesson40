package uz.gita.lesson40.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.lesson40.R
import uz.gita.lesson40.databinding.FragmentTransferBinding

class TransferFragment : Fragment(R.layout.fragment_transfer) {
    private val binding: FragmentTransferBinding by viewBinding()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.back.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }
}