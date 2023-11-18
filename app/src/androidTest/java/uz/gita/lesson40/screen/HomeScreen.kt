package uz.gita.lesson40.screen

import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KTextView
import uz.gita.lesson40.R

object HomeScreen : KScreen<HomeScreen>() {
    override val layoutId: Int? = null
    override val viewClass: Class<*>? = null

    val welcomeText = KTextView { withId(R.id.tv) }
}