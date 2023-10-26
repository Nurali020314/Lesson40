package uz.gita.lesson40.presentation

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import uz.gita.lesson40.R
import uz.gita.lesson40.data.constants.ErrorCodes
import uz.gita.lesson40.databinding.FragmentRegisterBinding
import uz.gita.lesson40.databinding.SignInScreenBinding

@AndroidEntryPoint
class SignInScreen : Fragment(R.layout.sign_in_screen) {
    private val binding: SignInScreenBinding by viewBinding()
    private val viewModel: SignInviewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.openVerifyLiveData.observe(viewLifecycleOwner, openVerifyLiveDataObserver)
        viewModel.errorLiveData.observe(viewLifecycleOwner, errorLiveDataObserver)
        viewModel.noNetworkLiveData.observe(viewLifecycleOwner, noNetworkLiveDataObserver)


        binding.signUpTv.setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.container, RegisterFragment())
                .addToBackStack("sinUp").commit()
        }

        binding.signin.setOnClickListener {

            val phone = binding.phone.text?.toString()
            val password = binding.password.text?.toString()
            viewModel.signIn(password, phone)
        }

        binding.lay1.setOnClickListener {
            binding.apply {
                lay1.setBackgroundResource(R.drawable.button1_sign_in_continue)
                lay2.setBackgroundResource(R.drawable.button2_sign_in_continue)
            }
        }
        binding.lay2.setOnClickListener {
            binding.apply {
                lay1.setBackgroundResource(R.drawable.button2_sign_in_continue)
                lay2.setBackgroundResource(R.drawable.button1_sign_in_continue)
            }
        }
    }

    private val openVerifyLiveDataObserver: Observer<Unit> = Observer {
        Toast.makeText(requireContext(), "Verifyni och", Toast.LENGTH_SHORT).show()
    }


    private val errorLiveDataObserver: Observer<Int> = Observer { error ->
        when (error) {
            ErrorCodes.PHONE_NUMBER -> {
                Log.d("aa", "kkk: ")
                Toast.makeText(requireContext(), "nomer", Toast.LENGTH_SHORT).show()
            }

            ErrorCodes.PASSWORD -> Toast.makeText(
                requireContext(),
                "password dj",
                Toast.LENGTH_SHORT
            ).show()

            //binding.password.error = "Noto'g'ri"
        }
    }

    private val noNetworkLiveDataObserver: Observer<Unit> = Observer {
        Toast.makeText(requireContext(), "Internet yo'q", Toast.LENGTH_SHORT).show()
    }


}