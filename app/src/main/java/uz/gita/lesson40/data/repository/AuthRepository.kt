package uz.gita.lesson40.data.repository

import uz.gita.lesson40.domain.entity.SignUpEntity
import uz.gita.lesson40.domain.entity.SignUpResponse

interface AuthRepository {
    var temporaryToken: String?
    var code: String?

    suspend fun signUp(signUpEntity: SignUpEntity): SignUpResponse
}