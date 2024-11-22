package com.example.pertemuanke8.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.pertemuanke8.model.Mahasiswa
import com.example.pertemuanke8.ui.view.screen.SplashView
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
){
    val mahasiswaUiState = mahasiswaViewModel.mahasiswaUiState.collectAsState().value
    Navhost(
        navController= navController,
        startDestination = Halaman.Splash.name,
        modifier = modifier.padding()
    ){
        composable(route = Halaman.Splash.name) {
            SplashView(onMulaibutton = {
                navController.navigate(
                    Halaman.Mahasiswa.name
                )
            })
        }
    }
}


