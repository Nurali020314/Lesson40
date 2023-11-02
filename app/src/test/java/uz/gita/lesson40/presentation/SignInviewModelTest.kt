//package uz.gita.lesson40.presentation
//
//import junit.framework.TestCase.assertEquals
//import junit.framework.TestCase.assertTrue
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.test.StandardTestDispatcher
//import kotlinx.coroutines.test.UnconfinedTestDispatcher
//import kotlinx.coroutines.test.resetMain
//import kotlinx.coroutines.test.runCurrent
//import kotlinx.coroutines.test.runTest
//import kotlinx.coroutines.test.setMain
//import org.junit.After
//import org.junit.Before
//import org.junit.Test
//import org.mockito.Mockito
//import uz.gita.lesson40.data.constants.State
//import uz.gita.lesson40.domain.SignInUseCase
//
//class SignInviewModelTest {
//    private val signInUseCase = Mockito.mock(SignInUseCase::class.java)
//    private lateinit var signInviewModel: SignInviewModel
//
//    @Before
//    fun setUp() {
//        signInviewModel = SignInviewModel(signInUseCase)
//        Dispatchers.setMain(StandardTestDispatcher())
//    }
//
//
//    @Test
//    fun testing_Sign_in() = runTest {
//
//        Mockito.`when`(signInUseCase.invoke(Mockito.anyString(), Mockito.anyString()))
//            .thenReturn(State.Success<Unit>())
//
//        val list = mutableListOf<Unit>()
//        val job = launch(UnconfinedTestDispatcher(testScheduler)) {
//            signInviewModel.openVerifyFlow.collect() {
//                list.add(it)
//
//            }
//        }
//        signInviewModel.signIn("123456", "+998940214314")
//        runCurrent()
//        job.cancel()
//
//        assertTrue(list.size == 1)
//        assertEquals(Unit, list.first())
//    }
//
//    @Test
//    fun testing_error_Sign_in() = runTest {
//
//        Mockito.`when`(signInUseCase.invoke(Mockito.anyString(), Mockito.anyString()))
//            .thenReturn(State.Error(404))
//
//        signInviewModel.signIn("123456", "+998940214314")
//
//        runCurrent()
//
//
//        assertEquals(404,signInviewModel.errorFlow.value)
//    }
//
//
//    @After
//    fun teardown() {
//        Dispatchers.resetMain()
//    }
//
//}