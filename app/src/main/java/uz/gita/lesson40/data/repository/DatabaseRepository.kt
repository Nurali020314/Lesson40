package uz.gita.lesson40.data.repository

import uz.gita.lesson40.domain.entity.CardHistoryEntity

interface DatabaseRepository {
    suspend fun insert(entities: List<CardHistoryEntity>)
    suspend fun getAll(): List<CardHistoryEntity>
    suspend fun get(isSuccess: Boolean): List<CardHistoryEntity>
}