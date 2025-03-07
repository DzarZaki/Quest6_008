package com.example.pertemuanke8.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pertemuanke8.model.Mahasiswa
import com.example.pertemuanke8.ui.view.screen.MahasiswaFormView
import com.example.pertemuanke8.ui.view.screen.RencanaStudyView
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
    val mahasiswaUiState = mahasiswaViewModel.mhsStateUi.collectAsState().value
    val rencanastudiUiState = RencanaStudyViewModel.krsStateUi.collectAsState().value
    NavHost(
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
        composable(route = Halaman.Mahasiswa.name) {
            MahasiswaFormView(
                onSubmitButtonClicked = {
                    mahasiswaViewModel.saveDataMhs(it)
                    navController.navigate(Halaman.Matakuliah.name)
                },
                onBackButtonClicked = {
                    navController.popBackStack()
                }
            )
        }
        composable(route = Halaman.Matakuliah.name) {
            RencanaStudyView(
                mahasiswa = mahasiswaUiState,
                onSubmitButtonClicked = {KrsViewModel.saveDataKRS(it)},
                onBackButtonClicked = {navController.popBackStack()}
            )
        }
        composable(route = Halaman.Tampil.name){
            DetailMahasiswaView(
                dataMhs = mahasiswaUiState,
                DataKRS = rencanastudiUiState,
                onClickButton = {
                    navController.popBackStack()
                }
            )
        }
    }
}




