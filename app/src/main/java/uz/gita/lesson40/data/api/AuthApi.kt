package uz.gita.lesson40.data.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import uz.gita.lesson40.domain.entity.SignInEntity
import uz.gita.lesson40.domain.entity.SignInResponse
import uz.gita.lesson40.domain.entity.SignUpEntity
import uz.gita.lesson40.domain.entity.SignUpResponse

interface AuthApi {
    @POST("auth/sign-up")
    suspend fun signUp(@Body signUpEntity: SignUpEntity): SignUpResponse

    @POST("auth/sign-in")
    suspend fun signIn(@Body signInEntity: SignInEntity): Response<SignInResponse>



}