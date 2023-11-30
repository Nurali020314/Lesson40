package uz.gita.lesson40.data.datasource

import uz.gita.lesson40.domain.entity.CardHistoryEntity

interface DataBaseDataSource {
    suspend fun insert(entities: List<CardHistoryEntity>)
    suspend fun getAll(): List<CardHistoryEntity>
    suspend fun get(isSuccess: Boolean): List<CardHistoryEntity>
}