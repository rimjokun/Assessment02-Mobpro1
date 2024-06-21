package org.d3if3032.assessment02.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if3032.assessment02.model.Data

@Database(entities = [Data::class], version = 1, exportSchema = false)
abstract class DataDb:RoomDatabase() {
    abstract val dao:DataDao
    companion object{
        @Volatile
        private var INSTANCE: DataDb? = null

        fun getInstance(context: Context):DataDb{
            synchronized(this){
                var instance = INSTANCE

                if (instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        DataDb::class.java,
                        "data.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}