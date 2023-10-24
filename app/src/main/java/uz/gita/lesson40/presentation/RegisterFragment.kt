package uz.gita.lesson40.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import by.kirich1409.viewbindingdelegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.lesson40.R
import uz.gita.lesson40.data.constants.ErrorCodes
import uz.gita.lesson40.databinding.FragmentRegisterBinding

@AndroidEntryPoint
class RegisterFragment : Fragment(R.layout.fragment_register) {
    private val binding: FragmentRegisterBinding by viewBinding()
    private val viewModel: RegisterViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.openVerifyLiveData.observe(viewLifecycleOwner, openVerifyLiveDataObserver)
        viewModel.errorLiveData.observe(viewLifecycleOwner, errorLiveDataObserver)
        viewModel.noNetworkLiveData.observe(viewLifecycleOwner, noNetworkLiveDataObserver)

        binding.register.setOnClickListener {
            val firstName = binding.firstName.text?.toString()
            val lastName = binding.lastName.text?.toString()
            val phone = binding.phone.text?.toString()
            val password = binding.password.text?.toString()
            viewModel.signUp(firstName, lastName, password, phone)
        }
    }

    private val openVerifyLiveDataObserver: Observer<Unit> = Observer {
        Toast.makeText(requireContext(), "Verifyni och", Toast.LENGTH_SHORT).show()
    }

    private val errorLiveDataObserver: Observer<Int> = Observer { error ->
        when (error) {
            ErrorCodes.FIRST_NAME_ERROR -> binding.firstName.error = "Noto'g'ri"
            ErrorCodes.LAST_NAME_ERROR -> binding.lastName.error = "Noto'g'ri"
            ErrorCodes.PHONE_NUMBER -> binding.phone.error = "Noto'g'ri"
            ErrorCodes.PASSWORD -> binding.password.error = "Noto'g'ri"
        }
    }

    private val noNetworkLiveDataObserver: Observer<Unit> = Observer {
        Toast.makeText(requireContext(), "Internet yo'q", Toast.LENGTH_SHORT).show()
    }
}