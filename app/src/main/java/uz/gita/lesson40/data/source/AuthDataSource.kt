package uz.gita.lesson40.data.source

import uz.gita.lesson40.domain.entity.SignInEntity
import uz.gita.lesson40.domain.entity.SignInResponse
import uz.gita.lesson40.domain.entity.SignUpEntity
import uz.gita.lesson40.domain.entity.SignUpResponse

interface AuthDataSource {
    var temporaryToken: String?
    var code: String?
    var signInToken:String?

    suspend fun signUp(signUpEntity: SignUpEntity): SignUpResponse
    suspend fun signIn(signInEntity: SignInEntity): SignInResponse
}