package com.example.pertemuanke8.ui.view.screen

import androidx.compose.runtime.Composable
import com.example.pertemuanke8.model.Mahasiswa
import com.example.pertemuanke8.model.RencanaStudi

@Composable
fun DetailMahasiswaView(
    dataMhs: Mahasiswa,
    DataKRS: RencanaStudi,
    onClickButton: () -> Unit

){
    val listDataMhs = listOf(
        Pair("Nama", dataMhs.nama),
        Pair("Email", dataMhs.email),
        Pair("NIM", dataMhs.nim),
    )
    val listDataKRS = listOf(
        Pair("Mata Kuliah", DataKRS.namaMK),
        Pair("Kelas", DataKRS.kelas)
    )
