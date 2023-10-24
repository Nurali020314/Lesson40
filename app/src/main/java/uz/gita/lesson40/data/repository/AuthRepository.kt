package uz.gita.lesson40.data.repository

import retrofit2.Response
import uz.gita.lesson40.domain.entity.SignInEntity
import uz.gita.lesson40.domain.entity.SignInResponse
import uz.gita.lesson40.domain.entity.SignUpEntity
import uz.gita.lesson40.domain.entity.SignUpResponse

interface AuthRepository {
    var temporaryToken: String?
    var code: String?
    var signInToken:String?

    suspend fun signUp(signUpEntity: SignUpEntity): SignUpResponse
    suspend fun SignIn(signInEntity: SignInEntity):Response<SignInResponse>
}