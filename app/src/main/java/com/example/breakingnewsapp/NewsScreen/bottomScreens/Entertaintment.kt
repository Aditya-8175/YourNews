package com.example.breakingnewsapp.NewsScreen.bottomScreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.breakingnewsapp.Data.TopNews
import com.example.breakingnewsapp.NewsScreen.BottomReal
import com.example.breakingnewsapp.NewsScreen.MainNewsContent
import com.example.breakingnewsapp.NewsScreen.NewsViewModel
import com.example.breakingnewsapp.component.TopBAr
import com.example.breakingnewsapp.dataorexception.DataOrException

@Composable
fun Entertaintment(
    modifier: Modifier = Modifier,
    navController: NavController,
    entertainment: NewsViewModel
) {

    var enjoy = produceState<DataOrException<TopNews, Boolean, Exception>>(
        initialValue = DataOrException(loading = true)
    ) {
        value = entertainment.getTopHeadlines("entertainment")
    }.value


    when {
        enjoy.loading == true -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        enjoy.data != null -> {

            Scaffold(
                topBar = { TopBAr(navController = navController) },
                bottomBar = { BottomReal(navController = navController) }
            ) {
                Column(modifier = Modifier.padding(it)) {
                    MainNewsContent(navController = navController, newList = enjoy.data!!.articles)
                }

            }

        }

        enjoy.e != null -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Error occur ${enjoy.e!!.message}")
            }
        }
    }

}