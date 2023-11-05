package uz.gita.lesson40.data.source

import retrofit2.Response
import uz.gita.lesson40.data.api.AuthApi
import uz.gita.lesson40.domain.entity.AddCardEntity
import uz.gita.lesson40.domain.entity.CardResponse
import uz.gita.lesson40.domain.entity.getResponse.GetCardsesponse
import javax.inject.Inject

class CardsDataSourseImpl @Inject constructor(
    private val authApi:AuthApi):CardsDataSourse {
    override suspend fun addCards(addCardEntity: AddCardEntity, bearerToken: String): Response<CardResponse> {
        return authApi.addCard(addCardEntity,bearerToken)
    }

    override suspend fun getCards(bearerToken: String): GetCardsesponse {
        return authApi.getCards(bearerToken)
    }

    override suspend fun delete(id: String, bearerToken: String): Response<String> {
        return authApi.deleteCards(id,bearerToken)
    }


}