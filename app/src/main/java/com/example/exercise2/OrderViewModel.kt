package com.example.exercise2

import androidx.lifecycle.ViewModel
import com.example.exercise2.data.OrderUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class OrderViewModel : ViewModel() {
    private val _stateUI = MutableStateFlow(OrderUIState())
    val stateUI: StateFlow<OrderUIState> = _stateUI.asStateFlow()

    fun setDosen1(dosenPilihan1: String){
        _stateUI.update { stateSaatIni -> stateSaatIni.copy(dosen = dosenPilihan1)}
    }

    fun setDosen2(dosenPilihan2: String){
        _stateUI.update { stateSaatIni -> stateSaatIni.copy(dosen = dosenPilihan2)}
    }

    fun setDataMahasiswa(listDataMahasiswa: MutableList<String>) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                nama = listDataMahasiswa[0],
                nim = listDataMahasiswa[1],
                konsentrasi = listDataMahasiswa[2],
                judul = listDataMahasiswa[3],
            )
        }
    }
}