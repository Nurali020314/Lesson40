package uz.gita.lesson40

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import uz.gita.lesson40.presentation.RegisterFragment
import uz.gita.lesson40.presentation.SignInScreen
import uz.gita.lesson40.presentation.Splash
import uz.gita.lesson40.presentation.ui.Home
import uz.gita.lesson40.presentation.ui.PinCode

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container,Splash()).commit()
    }
}