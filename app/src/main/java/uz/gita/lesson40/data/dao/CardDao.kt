package uz.gita.lesson40.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import uz.gita.lesson40.domain.entity.CardHistoryEntity

@Dao
interface CardDao {
    @Insert
    fun insert(entities: List<CardHistoryEntity>)

    @Query("SELECT * FROM `transaction`")
    fun getAll(): List<CardHistoryEntity>

    @Query("SELECT * FROM `transaction` WHERE isSuccess = :isSuccess")
    fun get(isSuccess: Boolean): List<CardHistoryEntity>
}