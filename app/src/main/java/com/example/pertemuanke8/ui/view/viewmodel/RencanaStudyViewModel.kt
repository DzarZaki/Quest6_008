package com.example.pertemuanke8.ui.view.viewmodel

import com.example.pertemuanke8.model.RencanaStudi
import kotlinx.coroutines.flow.StateFlow

class RencanaStudyViewModel : viewModel() {
    private val _krsState = mutableStateFlow(RencanaStudi())
    val krsStateUi: StateFlow<RencanaStudi> = _krsState.asStateFlow()

    fun setMataKuliah(mkPilihan: String) {
        _krsState.update { stateMK -> stateMK.copy(namaMK = mkPilihan)}
    }
}