package org.d3if3032.assessment02.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.d3if3032.assessment02.model.Data

@Dao
interface DataDao {
    @Insert
    suspend fun insert(data: Data)
    @Update
    suspend fun update(data: Data)
    @Query("SELECT * FROM data ORDER By matkul,judul ASC")
    fun getData(): Flow<List<Data>>
    @Query("SELECT * FROM data WHERE id = :id")
    suspend fun getDataById(id:Long):Data?
    @Query("DELETE FROM data WHERE id = :id")
    suspend fun deleteById(id:Long)

}