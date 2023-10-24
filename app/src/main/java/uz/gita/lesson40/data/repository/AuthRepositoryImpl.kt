package uz.gita.lesson40.data.repository

import uz.gita.lesson40.data.source.AuthDataSource
import uz.gita.lesson40.domain.entity.SignUpEntity
import uz.gita.lesson40.domain.entity.SignUpResponse
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource
) : AuthRepository {
    override var temporaryToken: String?
        get() = authDataSource.temporaryToken
        set(value) {
            authDataSource.temporaryToken = value
        }
    override var code: String?
        get() = authDataSource.code
        set(value) {
            authDataSource.code = value
        }

    override suspend fun signUp(signUpEntity: SignUpEntity): SignUpResponse {
        return authDataSource.signUp(signUpEntity)
    }
}