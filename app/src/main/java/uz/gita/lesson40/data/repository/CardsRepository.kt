package uz.gita.lesson40.data.repository

import retrofit2.Response
import retrofit2.http.Body
import uz.gita.lesson40.domain.entity.AddCardEntity
import uz.gita.lesson40.domain.entity.CardResponse
import uz.gita.lesson40.domain.entity.TransferEntity
import uz.gita.lesson40.domain.entity.TransferResponse
import uz.gita.lesson40.domain.entity.getResponse.GetCardsesponse

interface CardsRepository {
    suspend fun addCards(@Body addCardEntity: AddCardEntity,  bearerToken:String): Response<CardResponse>

    suspend fun getCards( bearerToken:String): GetCardsesponse

    suspend fun transfer(bearerToken:String, transferEntity: TransferEntity):Response<TransferResponse>

}