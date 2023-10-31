package uz.gita.lesson40.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import uz.gita.lesson40.R
import uz.gita.lesson40.databinding.AccountPincodeBinding

class PinCode:Fragment(R.layout.account_pincode) {
    private val biding:AccountPincodeBinding by viewBinding()
    private val newPinCode:String=""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

}