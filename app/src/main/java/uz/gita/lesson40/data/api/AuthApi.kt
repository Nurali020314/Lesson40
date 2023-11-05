package uz.gita.lesson40.data.api

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import uz.gita.lesson40.domain.entity.AddCardEntity
import uz.gita.lesson40.domain.entity.CardResponse
import uz.gita.lesson40.domain.entity.SignInEntity
import uz.gita.lesson40.domain.entity.SignInResponse
import uz.gita.lesson40.domain.entity.SignUpEntity
import uz.gita.lesson40.domain.entity.SignUpResentEntity
import uz.gita.lesson40.domain.entity.SignUpResentResponse
import uz.gita.lesson40.domain.entity.SignUpResponse
import uz.gita.lesson40.domain.entity.getResponse.GetCardsesponse

interface AuthApi {
    @POST("auth/sign-up")
    suspend fun signUp(@Body signUpEntity: SignUpEntity): SignUpResponse

    @POST("auth/sign-in")
    suspend fun signIn(@Body signInEntity: SignInEntity): Response<SignInResponse>

    @POST("sign-up/resend")
    suspend fun signUpResent(@Body signUpResentEntity: SignUpResentEntity): Response<SignUpResentResponse>

    @POST("cards")
    suspend fun addCard(@Body addCardEntity: AddCardEntity, @Header("Authorization") bearerToken:String):Response<CardResponse>

    @GET("cards")
    suspend fun getCards(@Header("Authorization") bearerToken :String):GetCardsesponse

    @DELETE("cards/{id}")
    suspend fun deleteCards(@Path("id") id: String, @Header("Authorization") bearerToken: String): Response<String>

}