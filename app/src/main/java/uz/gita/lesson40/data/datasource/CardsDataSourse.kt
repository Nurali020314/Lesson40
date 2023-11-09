package uz.gita.lesson40.data.datasource

import retrofit2.Response
import retrofit2.http.Body
import uz.gita.lesson40.domain.entity.AddCardEntity
import uz.gita.lesson40.domain.entity.CardResponse
import uz.gita.lesson40.domain.entity.PaymentResponse
import uz.gita.lesson40.domain.entity.TransferEntity
import uz.gita.lesson40.domain.entity.TransferResponse
import uz.gita.lesson40.domain.entity.TransferVerifyEntity
import uz.gita.lesson40.domain.entity.getResponse.GetCardsesponse
import uz.gita.lesson40.domain.entity.getResponse.TransferVerifyResponse

interface CardsDataSourse {
    suspend fun addCards(addCardEntity: AddCardEntity,bearerToken:String):Response<CardResponse>

    suspend fun getCards(bearerToken:String):GetCardsesponse

    suspend fun transfer(bearerToken:String, transferEntity: TransferEntity):Response<TransferResponse>

    suspend fun transferVerify(bearerToken:String, transferVerifyEntity: TransferVerifyEntity):Response<TransferVerifyResponse>
    suspend fun payment(bearerToken:String):Response<PaymentResponse>

}