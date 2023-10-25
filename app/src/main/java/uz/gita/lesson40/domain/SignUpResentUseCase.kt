package uz.gita.lesson40.domain

import uz.gita.lesson40.data.constants.State
import uz.gita.lesson40.data.repository.AuthRepository
import javax.inject.Inject

class SignUpResentUseCase @Inject constructor(val authRepository: AuthRepository) {
    suspend operator fun invoke(password: String?, phone: String?): State {


        // try {
        //     val entity = SignInEntity(password, phone)
        //     val response = authRepository.SignIn(entity)


        //     if (response.code() == 422) {

        //         return State.Error(ErrorCodes.PASSWORD)

        //     }
        //     val body = response.body() as SignInResponse
        //     authRepository.signInToken = body.access_token
        //     Log.d("tagg", "${body.access_token} ")


        // } catch (exception: Exception) {
        //     exception.printStackTrace()
        //     if (exception is IOException) return State.NoNetwork
        //     return State.Error(1)
        // }
        return State.Success<Unit>()
    }

}