package uz.gita.lesson40

import androidx.test.espresso.matcher.ViewMatchers.hasErrorText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import uz.gita.lesson40.screen.HomeScreen
import uz.gita.lesson40.screen.LoginScreen

@RunWith(AndroidJUnit4::class)
class LoginTest : TestCase() {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun loginKaspressoTest() {
        run {
            step("Check visibility") {
                LoginScreen {
                    passwordEdt.isDisplayed()
                    phoneEdt.isDisplayed()
                    loginButton.isDisplayed()
                    goToRegisterButton.isDisplayed()
                }
            }
            step("Check errors") {
                LoginScreen {
                    loginButton.click()
                    phoneEdt {
                        isDisplayed()
                        hasErrorText("Incorrect")
                    }
                }
                Thread.sleep(1000L)
            }
            step("Fill fields and login") {
                LoginScreen {
                    phoneEdt.typeText("941302228")
                    passwordEdt.typeText("12345678")
                    closeSoftKeyboard()
                    Thread.sleep(1000L)
                    loginButton.click()
                }
                HomeScreen {
                    welcomeText {
                        isDisplayed()
                        containsText("Enter the PIN code")
                    }
                }
            }
        }
    }
}