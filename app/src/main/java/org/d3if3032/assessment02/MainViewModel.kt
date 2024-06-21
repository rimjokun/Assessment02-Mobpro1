package org.d3if3032.assessment02

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.d3if3032.assessment02.database.DataDao
import org.d3if3032.assessment02.model.Data

class MainViewModel(dao: DataDao) : ViewModel() {
    val data : StateFlow<List<Data>> = dao.getData().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )
}