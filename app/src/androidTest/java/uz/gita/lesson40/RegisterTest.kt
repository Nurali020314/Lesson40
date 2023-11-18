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
import uz.gita.lesson40.screen.RegisterScreen
import uz.gita.lesson40.screen.VerifyScreen

@RunWith(AndroidJUnit4::class)
class RegisterTest : TestCase() {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun registerKaspressoTest() {
        run {
            step("Check visibility") {
                LoginScreen {
                    goToRegisterButton.click()
                }
                RegisterScreen {
                    firstNameEdt.isDisplayed()
                    lastNameEdt.isDisplayed()
                    passwordEdt.isDisplayed()
                    phoneEdt.isDisplayed()
                }
            }
            step("Check errors") {
                RegisterScreen {
                    registerButton.click()
                    firstNameEdt{
                        hasErrorText("Incorrect")
                    }
                }
            }
            step("Fill fields and login") {
                RegisterScreen {
                    firstNameEdt.typeText("Abduazim")
                    lastNameEdt.typeText("Abduqahhorov")
                    phoneEdt.typeText("941302223")
                    closeSoftKeyboard()
                    passwordEdt.typeText("12345678")
                    closeSoftKeyboard()
                    registerButton.click()

                }
                Thread.sleep(17 * 1000L)
                VerifyScreen {
                    verifyButton.click()
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