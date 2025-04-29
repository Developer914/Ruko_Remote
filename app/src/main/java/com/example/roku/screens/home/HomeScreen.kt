package com.example.roku.screens.home

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.roku.composable.BottomNavigationBar
import com.example.roku.navigation.BottomNavHost

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    applicationContext: Context,
    navController: NavHostController
) {
    val bottomNavController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(bottomNavController,applicationContext)
        }
    ){
        BottomNavHost(bottomNavController, navController,applicationContext)
    }
}