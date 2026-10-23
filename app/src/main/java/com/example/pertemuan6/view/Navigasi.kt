package com.example.pertemuan6.view

import android.net.Uri
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

enum class Navigasi {
    FormulirSaya,
    Detail
}

@Composable
fun DataApp(
    navController: NavHostController = rememberNavController()
) {
    Scaffold { isiRuang ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.FormulirSaya.name,
            modifier = Modifier.padding(isiRuang)
        ) {
            composable(route = Navigasi.FormulirSaya.name) {
                FormIsian(
                    OnSubmitBtnClick = { nama, jenisK, alamat ->
                        navController.navigate(
                            "${Navigasi.Detail.name}/${
                                Uri.encode(nama)
                            }/${
                                Uri.encode(jenisK)
                            }/${
                                Uri.encode(alamat)
                            }"
                        )
                    }
                )
            }

            composable(
                route = "${Navigasi.Detail.name}/{nama}/{jenisK}/{alamat}",
                arguments = listOf(
                    navArgument("nama") { type = NavType.StringType },
                    navArgument("jenisK") { type = NavType.StringType },
                    navArgument("alamat") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                TampilData(
                    nama = Uri.decode(
                        backStackEntry.arguments?.getString("nama").orEmpty()
                    ),
                    jenisK = Uri.decode(
                        backStackEntry.arguments?.getString("jenisK").orEmpty()
                    ),
                    alamat = Uri.decode(
                        backStackEntry.arguments?.getString("alamat").orEmpty()
                    ),
                    onBackBtnClick = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
