package uz.gita.lesson40.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import retrofit2.Response
import uz.gita.lesson40.data.constants.State
import uz.gita.lesson40.data.repository.AuthRepository
import uz.gita.lesson40.domain.entity.SignInResponse
import uz.gita.lesson40.presentation.SignInviewModel


class SignInUseCaseTest {
    private val authRepository: AuthRepository = Mockito.mock(AuthRepository::class.java)
    private lateinit var signInUseCase: SignInUseCase

    @Before
    fun setUp() {
        signInUseCase = SignInUseCase(authRepository)
        Dispatchers.setMain(StandardTestDispatcher())
    }

    @Test
    fun signInUseCase_test() = runTest {

        val token = "token"

       // Mockito.`when`(authRepository.SignIn(any())).thenReturn(Response)

        signInUseCase.invoke("Nz214214", "+998940304314")

        Mockito.verify(authRepository, Mockito.times(1)).signInToken = token

    }

    @After
    fun teardown() {
        Dispatchers.resetMain()
    }

    private fun <T> any(): T = Mockito.any()
}