package uz.gita.lesson40.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import uz.gita.lesson40.data.constants.State
import uz.gita.lesson40.domain.SignInUseCase
import javax.inject.Inject

@HiltViewModel
class SignInviewModel @Inject constructor(
    private val signInUseCase: SignInUseCase
) : ViewModel() {


    private val _openVerifyFlow = MutableSharedFlow<Unit>()
    val openVerifyFlow: SharedFlow<Unit> = _openVerifyFlow

    private val _errorFlow = MutableStateFlow(0)
    val errorFlow: StateFlow<Int> = _errorFlow


    private val _noNetworkFlow = MutableSharedFlow<Unit>()
    val noNetworkFlow: SharedFlow<Unit> = _noNetworkFlow


    fun signIn(password: String?, phone: String?) {
        viewModelScope.launch {
            val state = signInUseCase(password, phone)
            handleState(state)
        }
    }

    private suspend fun handleState(state: State) {
        when (state) {
            is State.Success<*> -> _openVerifyFlow.emit(Unit)
            is State.Error -> _errorFlow.emit(state.code)
            State.NoNetwork -> _noNetworkFlow.emit(Unit)
        }

    }
}