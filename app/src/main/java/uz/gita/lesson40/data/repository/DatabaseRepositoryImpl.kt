package uz.gita.lesson40.data.repository

import uz.gita.lesson40.data.datasource.DataBaseDataSource
import uz.gita.lesson40.domain.entity.CardHistoryEntity
import javax.inject.Inject

class DatabaseRepositoryImpl @Inject constructor(val dataSource: DataBaseDataSource): DatabaseRepository {
    override suspend fun insert(entities: List<CardHistoryEntity>) {
        dataSource.insert(entities)
    }

    override suspend fun getAll(): List<CardHistoryEntity> {
        return dataSource.getAll()
    }

    override suspend fun get(isSuccess: Boolean): List<CardHistoryEntity> {
        return dataSource.get(isSuccess)
    }
}