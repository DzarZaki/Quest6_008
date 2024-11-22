package com.example.pertemuanke8.ui.view.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.pertemuanke8.model.Mahasiswa
import com.example.pertemuanke8.model.RencanaStudi
import java.lang.reflect.Modifier

@Composable
fun DetailMahasiswaView(
    dataMhs: Mahasiswa,
    dataKRS: RencanaStudi,
    onClickButton: () -> Unit
) {
    val listDataMhs = listOf(
        Pair("Nama", dataMhs.nama),
        Pair("Email", dataMhs.email),
        Pair("NIM", dataMhs.nim),
    )
    val listDataKRS = listOf(
        Pair("Mata Kuliah", dataKRS.namaMK),
        Pair("Kelas", dataKRS.kelas)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)  // Adding padding here
    ) {
        // Displaying Mahasiswa data
        listDataMhs.forEach { data ->
            DetailMhs(judul = data.first, isinya = data.second)
        }

        // Displaying Rencana Studi data
        listDataKRS.forEach { data ->
            DetailMhs(judul = data.first, isinya = data.second)
        }

        // Button for action
        Button(
            onClick = { onClickButton() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text("Kembali")
        }
    }
}

@Composable
fun DetailMhs(judul: String, isinya: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)  // Adjusted padding for better spacing
    ) {
        Text(
            text = judul,
            modifier = Modifier.weight(0.8f)
        )
        Text(
            text = ":",
            modifier = Modifier.weight(0.2f)
        )
        Text(
            text = isinya,
            modifier = Modifier.weight(2f)
        )
    }
}
