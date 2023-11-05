package uz.gita.lesson40.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import uz.gita.lesson40.data.constants.State
import uz.gita.lesson40.domain.DeleteUseCase
import uz.gita.lesson40.domain.GetCardUseCase
import uz.gita.lesson40.domain.entity.getResponse.Data
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor(private val getCardUseCase: GetCardUseCase,private val deleteUseCase: DeleteUseCase):ViewModel() {

    private val _openSuccsesFlow = MutableSharedFlow<List<Data>>()
    val openSuccesFlow:SharedFlow<List<Data>> =_openSuccsesFlow

    private val _openSuccsesDeleteFlow = MutableSharedFlow<String>()
    val openSuccesDeleteFlow:SharedFlow<String> =_openSuccsesDeleteFlow

    private val _openErrorFlow = MutableSharedFlow<Int>()
    val openErrorFlow:SharedFlow<Int> =_openErrorFlow

    private val _openNetworkFlow = MutableSharedFlow<Unit>()
    val openNetworkFlow:SharedFlow<Unit> =_openNetworkFlow

    fun getCards(){
        viewModelScope.launch {
            val state=getCardUseCase.invoke()
            handleState(state)
        }
    }

    fun deleteItem(id:String){
        viewModelScope.launch {
            val state=deleteUseCase.invoke(id)
            handleDeleteState(state)
        }
    }

    private suspend fun handleDeleteState(state: State) {
        when(state){
            is State.Error -> _openErrorFlow.emit(state.code)
            State.NoNetwork -> _openNetworkFlow.emit(Unit)
            is State.Success<*> -> _openSuccsesDeleteFlow.emit(state.data.toString())
        }

    }

    private suspend fun handleState(state: State) {
        when(state){
            is State.Error -> _openErrorFlow.emit(state.code)
            State.NoNetwork -> _openNetworkFlow.emit(Unit)
            is State.Success<*>->_openSuccsesFlow.emit(state.data as List<Data>)
        }
    }
}