package uz.gita.lesson40.screen

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KButton
import uz.gita.lesson40.R

object LoginScreen : KScreen<LoginScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val phoneEdt = KEditText { withId(R.id.phone) }
    val passwordEdt = KEditText { withId(R.id.password) }
    val loginButton = KButton { withId(R.id.signin) }
    val goToRegisterButton = KButton { withId(R.id.signUp_tv) }
}