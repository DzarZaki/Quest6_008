package com.example.pertemuanke8.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pertemuanke8.model.Mahasiswa
import com.example.pertemuanke8.ui.view.viewmodel.MahasiswaViewModel
import com.example.pertemuanke8.ui.view.viewmodel.RencanaStudyViewModel

enum class Halaman {
    Splash,
    Mahasiswa,
    Matakuliah,
    Tampil
}

@Composable
fun MahasiswaApp(
    modifier: Modifier = Modifier,
    mahasiswaViewModel: MahasiswaViewModel = viewModel(),
    KrsViewModel: RencanaStudyViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
){}
