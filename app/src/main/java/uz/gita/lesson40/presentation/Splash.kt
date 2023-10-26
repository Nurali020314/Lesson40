package uz.gita.lesson40.presentation

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import androidx.fragment.app.Fragment
import uz.gita.lesson40.R

class Splash : Fragment(R.layout.fragment_splash1) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        object : CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                parentFragmentManager.beginTransaction().replace(R.id.container, Splash1()).commit()
            }

        }.start()
    }
}