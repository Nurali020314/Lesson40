package uz.gita.lesson40.data.source

import uz.gita.lesson40.domain.entity.SignUpEntity
import uz.gita.lesson40.domain.entity.SignUpResponse

interface AuthDataSource {
    var temporaryToken: String?
    var code: String?

    suspend fun signUp(signUpEntity: SignUpEntity): SignUpResponse
}