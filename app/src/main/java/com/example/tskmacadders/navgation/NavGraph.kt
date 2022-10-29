package com.example.tskmacadders.navgation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tskmacadders.screens.HomeScreen
import com.example.tskmacadders.screens.ScanScreen

@Composable
fun SetUpNavGraph(
    navContoler: NavHostController
) {
    NavHost(
        navController =navContoler ,
        startDestination = Screen.Home.route
    ){
        composable(
            route = Screen.Home.route
        ){
            HomeScreen(navContoler)
        }
        composable(
            route = Screen.Scan.route
        ){
            ScanScreen()
        }
    }
}
