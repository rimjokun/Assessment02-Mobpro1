package org.d3if3032.assessment02.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "data")
data class Data (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val judul: String,
    val deskripsi: String,
    val matkul: String

)