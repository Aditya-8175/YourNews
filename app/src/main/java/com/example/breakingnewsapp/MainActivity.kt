package com.example.breakingnewsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.breakingnewsapp.NavigationComponents.NewsNavigation
import com.example.breakingnewsapp.NavigationComponents.NewsScreen
import com.example.breakingnewsapp.ui.theme.BreakingNewsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BreakingNewsAppTheme {
                NewsScreen()
            }
        }
    }
}