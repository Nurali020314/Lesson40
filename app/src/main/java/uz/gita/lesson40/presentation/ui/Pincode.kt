package uz.gita.lesson40.presentation.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.lesson40.R
import uz.gita.lesson40.databinding.AccountPincodeBinding

class PinCode : Fragment(R.layout.account_pincode) {
    private val binding: AccountPincodeBinding by viewBinding()
    private var input: String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        reset()
        loadViews()
    }

    private fun reset() {
        for (i in 0 until binding.tv2.childCount) {
            val img = binding.tv2.getChildAt(i) as ImageView
            img.setImageResource(R.drawable.empty)
        }
        input = ""
    }

    private fun loadViews() {
        for (i in 0 until binding.numbers.childCount) {
            val linear = binding.numbers.getChildAt(i) as LinearLayout
            for (j in 0 until linear.childCount) {
                if (i == 3 && (j == 0 || j == 2)) continue
                val cardView = linear.getChildAt(j) as CardView
                val text = cardView.getChildAt(0) as TextView
                text.setOnClickListener {
                    if (input.length < 4) {
                        val img = binding.tv2.getChildAt(input.length) as ImageView
                        img.setImageResource(R.drawable.full)
                        input += text.text
                    }
                    Toast.makeText(requireContext(), input, Toast.LENGTH_SHORT).show()
                }
            }
        }
        binding.back.setOnClickListener {
            back()
        }
    }

    private fun back() {
        if (input.isNotEmpty()) {
            val img = binding.tv2.getChildAt(input.length-1) as ImageView
            img.setImageResource(R.drawable.empty)
            input = input.substring(0, input.length - 1)
        }
    }

}