package com.example.esanavalospc01.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.esanavalospc01.HOME.Catalago
import com.example.esanavalospc01.HOME.EdadCanina


@Composable
fun NavigationMenu() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "catalogo") {
        // Pantalla del Catálogo de Laptops
        composable("catalogo") {
            DrawerScaffold(navController) {
                Catalago()
            }
        }

        // Pantalla de Edad Canina
        composable("edad_canina") {
            DrawerScaffold(navController) {
                EdadCanina()
            }
        }

        // Otras pantallas
        composable("permissions") {
            DrawerScaffold(navController) {
                // TODO: Permissions screen
                Text("Pantalla de permisos")
            }
        }

        composable("favorites") {
            DrawerScaffold(navController) {
                // TODO: Favorites screen
                Text("Pantalla de favoritos")
            }
        }
    }
}