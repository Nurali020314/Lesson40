package uz.gita.lesson40.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.lesson40.R
import uz.gita.lesson40.databinding.FragmentSplash2Binding

class Splash1:Fragment(R.layout.fragment_splash2) {
    private val binding: FragmentSplash2Binding by viewBinding()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            checkbox.setOnClickListener {
                if(checkbox.isChecked){
                    bottom.setBackgroundResource(R.color.purple_700)
                }
                else if (!checkbox.isChecked){
                    bottom.setBackgroundResource(R.color.purple_200)
                }
            }

            bottom.setOnClickListener {
                if (checkbox.isChecked){
                    parentFragmentManager.beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.container,SignInScreen())
                        .commit()
                }
                else{
                    Toast.makeText(requireContext(), "Do you Agree Privacy Policy", Toast.LENGTH_SHORT).show()
                }

            }
        }

    }
}