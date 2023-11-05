package uz.gita.lesson40.data.source

import retrofit2.Response
import retrofit2.http.Body
import uz.gita.lesson40.domain.entity.AddCardEntity
import uz.gita.lesson40.domain.entity.CardResponse
import uz.gita.lesson40.domain.entity.getResponse.GetCardsesponse

interface CardsDataSourse {
    suspend fun addCards(@Body addCardEntity: AddCardEntity,bearerToken:String):Response<CardResponse>

    suspend fun getCards(bearerToken:String):GetCardsesponse

    suspend fun delete(id:String,bearerToken:String):Response<String>
}