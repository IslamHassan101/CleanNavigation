package com.islam.cleannavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.islam.cleannavigation.main.MainScreen
import com.islam.cleannavigation.ui.theme.CleanNavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CleanNavigationTheme {
                MainScreen()
            }
        }
    }
}

