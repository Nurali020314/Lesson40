package uz.gita.lesson40.screen

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.edit.KEditText
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import uz.gita.lesson40.R

object RegisterScreen : KScreen<RegisterScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val firstNameEdt = KEditText { withId(R.id.first_Name) }
    val lastNameEdt = KEditText { withId(R.id.last_name) }
    val passwordEdt = KEditText { withId(R.id.password) }
    val phoneEdt = KEditText { withId(R.id.phone) }
    val registerButton = KButton { withId(R.id.register) }
}