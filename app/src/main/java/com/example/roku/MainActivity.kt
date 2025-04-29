package com.example.roku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.ui.platform.LocalContext
import com.example.roku.navigation.NavHostContainer
import com.example.roku.ui.theme.RokuTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RokuTheme {
                val applicationContext = LocalContext.current.applicationContext
                NavHostContainer(applicationContext)
            }
        }
    }
}