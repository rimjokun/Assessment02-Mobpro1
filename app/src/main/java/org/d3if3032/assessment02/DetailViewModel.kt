package org.d3if3032.assessment02

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3032.assessment02.database.DataDao
import org.d3if3032.assessment02.model.Data

class DetailViewModel(private val dao: DataDao): ViewModel() {
    fun insert(judul:String, deskripsi:String, matkul: String){
        val data = Data (
            judul = judul,
            deskripsi = deskripsi,
            matkul = matkul
        )
        viewModelScope.launch (Dispatchers.IO){
            dao.insert(data)
        }
    }

    suspend fun getData(id:Long): Data? {
        return dao.getDataById(id)
    }

    fun  update(id: Long, judul: String, deskripsi: String, matkul: String){
        val data = Data(
            id = id,
            judul = judul,
            deskripsi = deskripsi,
            matkul = matkul
        )
        viewModelScope.launch (Dispatchers.IO){
            dao.update(data)
        }

    }

    fun delete(id: Long){
        viewModelScope.launch(Dispatchers.IO){
            dao.deleteById(id)
        }
    }
}