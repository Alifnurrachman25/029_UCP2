package com.example.exercise2

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.exercise2.data.SumberData.dosens

enum class PengelolaHalaman {
    Satu,
    Dua,
    Tiga
}

@Composable
fun FormApp(
    viewModel: OrderViewModel = androidx.lifecycle.viewmodel.compose.viewModel(),
    navController: NavHostController = rememberNavController()
){
    val uiState by viewModel.stateUI.collectAsState()
    
    NavHost(navController = navController, startDestination = PengelolaHalaman.Satu.name){
        composable(route = PengelolaHalaman.Satu.name){
            HalamanSatu(
                onNextButtonClicked = {
                    navController.navigate(PengelolaHalaman.Dua.name)
                }
            )
        }
        composable(route = PengelolaHalaman.Dua.name){
            val context = LocalContext.current
            HalamanDua(
                pilihanDosen = dosens.map { id -> context.resources.getString(id) },
                onSelectionChanged1 = {viewModel.setDosen1(it)},
                onSelectionChanged2 = {viewModel.setDosen1(it)},
                onSubmitButtonClicked = {
                    viewModel.setDataMahasiswa(it)
                    navController.navigate(PengelolaHalaman.Tiga.name)
                }
            )
        }
        composable(route = PengelolaHalaman.Tiga.name){

        }
    }
}
