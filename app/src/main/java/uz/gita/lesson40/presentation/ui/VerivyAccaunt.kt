package uz.gita.lesson40.presentation.ui

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.lesson40.R
import uz.gita.lesson40.data.settings.SettingsImpl
import uz.gita.lesson40.databinding.SignInScreenBinding
import uz.gita.lesson40.databinding.VerificationScreenBinding
import uz.gita.lesson40.presentation.RegisterViewModel
import uz.gita.lesson40.presentation.SignUpResendViewModel

class VerivyAccaunt : Fragment(R.layout.verification_screen) {
    val settingsImpl: SettingsImpl by lazy { SettingsImpl(requireContext()) }
    private val viewModel: SignUpResendViewModel by viewModels()

    private val binding: VerificationScreenBinding by viewBinding()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var secound = 60

        Toast.makeText(requireContext(), "${settingsImpl.code}", Toast.LENGTH_SHORT).show()
        object : CountDownTimer(60000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                --secound

                if (secound == 45) {
                    binding.apply {
                        code1Tv.text =
                            Character.getNumericValue(settingsImpl.code.toString()[0]).toString()
                        code2Tv.text =
                            Character.getNumericValue(settingsImpl.code.toString()[1]).toString()
                        code3Tv.text =
                            Character.getNumericValue(settingsImpl.code.toString()[2]).toString()
                        code4Tv.text =
                            Character.getNumericValue(settingsImpl.code.toString()[3]).toString()
                        code5Tv.text =
                            Character.getNumericValue(settingsImpl.code.toString()[4]).toString()
                        code6Tv.text =
                            Character.getNumericValue(settingsImpl.code.toString()[5]).toString()
                    }
                }

                if (secound < 10) {
                    binding.timeCode.text = "00:0$secound"
                } else {
                    binding.timeCode.text = "00:$secound"
                }

            }

            override fun onFinish() {
                binding.apply {
                    code1.setBackgroundResource(R.drawable.incurrect_code)
                    code2.setBackgroundResource(R.drawable.incurrect_code)
                    code3.setBackgroundResource(R.drawable.incurrect_code)
                    code4.setBackgroundResource(R.drawable.incurrect_code)
                    code5.setBackgroundResource(R.drawable.incurrect_code)
                    code6.setBackgroundResource(R.drawable.incurrect_code)
                }

            }

        }.start()


        binding.resent2.setOnClickListener {
            viewModel.signIn("nnkc", "dncnd")
        }


    }

}