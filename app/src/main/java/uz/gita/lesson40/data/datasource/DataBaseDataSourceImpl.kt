package uz.gita.lesson40.data.datasource

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import uz.gita.lesson40.database.AppDataBase
import uz.gita.lesson40.domain.entity.CardHistoryEntity
import javax.inject.Inject

class DataBaseDataSourceImpl @Inject constructor(val database: AppDataBase) : DataBaseDataSource {
    override suspend fun insert(entities: List<CardHistoryEntity>) {
        withContext(Dispatchers.IO) {
            database.clearAllTables()
            database.databaseDao().insert(entities)
        }
    }

    override suspend fun getAll(): List<CardHistoryEntity> {
        return withContext(Dispatchers.IO){database.databaseDao().getAll()}
    }

    override suspend fun get(isSuccess: Boolean): List<CardHistoryEntity> {
        return withContext(Dispatchers.IO){database.databaseDao().get(isSuccess)}
    }
}