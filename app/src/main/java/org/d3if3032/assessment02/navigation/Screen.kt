package org.d3if3032.assessment02.navigation

import org.d3if3032.assessment02.ui.screen.KEY_ID_DATA

sealed class Screen(val route: String){
    data object Home: Screen("mainScreen")
    data object FormBaru: Screen("detailScreen")
    data object FormUbah: Screen("detailScreen/{$KEY_ID_DATA}"){
        fun withId(id: Long) = "detailScreen/$id"
    }
}