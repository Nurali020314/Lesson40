package uz.gita.lesson40.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import uz.gita.lesson40.data.constants.State
import uz.gita.lesson40.domain.AddCardUseCase
import uz.gita.lesson40.domain.entity.AddCardEntity
import javax.inject.Inject
@HiltViewModel
class AddCardViewModel @Inject constructor(private val addCardUseCase: AddCardUseCase):ViewModel(){
    private val _openSuccsesScreenFlow= MutableSharedFlow<String>()
    val openSuccsesScreenFlow:SharedFlow<String> = _openSuccsesScreenFlow

    private val _openErrorFlow= MutableSharedFlow<Int>()
    val openErrorFlow:SharedFlow<Int> = _openErrorFlow

    private val _openNetworkFlow= MutableSharedFlow<Unit>()
    val openNetworkFlow:SharedFlow<Unit> = _openNetworkFlow

    fun addCard(addCardEntity: AddCardEntity){
        viewModelScope.launch {
            val state = addCardUseCase.invoke(addCardEntity)
            handleState(state)

        }
    }

    private suspend fun handleState(state: State) {
        when(state){
            is State.Error -> _openErrorFlow.emit(state.code)
            State.NoNetwork -> _openNetworkFlow.emit(Unit)
            is State.Success<*> -> _openSuccsesScreenFlow.emit(state.data.toString())
        }
    }

}