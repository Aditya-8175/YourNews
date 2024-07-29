//package com.example.breakingnewsapp.NewsScreen.bottomScreens
//
//import android.net.Uri
//import android.util.Log
//import androidx.compose.foundation.Image
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Arrangement
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material3.Card
//import androidx.compose.material3.CardDefaults
//import androidx.compose.material3.CircularProgressIndicator
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Scaffold
//import androidx.compose.material3.Surface
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.produceState
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.layout.ContentScale
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.text.font.FontWeight
//import androidx.compose.ui.unit.dp
//import androidx.hilt.navigation.compose.hiltViewModel
//import androidx.navigation.NavController
//import coil.compose.rememberAsyncImagePainter
//import coil.request.ImageRequest
//import com.example.breakingnewsapp.Data.Article
//import com.example.breakingnewsapp.Data.TopNews
//import com.example.breakingnewsapp.NavigationComponents.NewsNavigation
//import com.example.breakingnewsapp.NewsScreen.BottomReal
//import com.example.breakingnewsapp.NewsScreen.NewsViewModel
//import com.example.breakingnewsapp.NewsScreen.TopBAr
//import com.example.breakingnewsapp.dataorexception.DataOrException
//import com.google.gson.Gson
//
//@Composable
//fun Headline(
//    modifier: Modifier = Modifier, navController: NavController,
//    viewModel: NewsViewModel = hiltViewModel()
////    , category: String
//) {
//
//    val EverythingNews = produceState<DataOrException<TopNews, Boolean, Exception>>(
//        initialValue = DataOrException(loading = true)
//    ) { value = viewModel.getTopHeadlines(category = "business") }.value
//    if (EverythingNews.loading == true){
//        CircularProgressIndicator()
//    }else if (EverythingNews.data != null) {
//
//        Column(modifier.background(Color.Cyan)) {
//            Scaffold(
//                topBar = {
//                    TopBAr(navController = navController)
//                }
//                , bottomBar = {
//                    BottomReal(navController = navController)
//                }
//            ) {
//                Column(modifier.padding(it)) {
//
////                Log.d("global", "GlobalNewsScreen: ${EverythingNews.data!!.articles}")
////                MainNewsContent(
////                    navController = navController,
////                    newList = EverythingNews.data!!.articles
////                )
//
//                    TopHeadLines(headline = EverythingNews.data!!.articles , navController = navController )
//                }
//
//            }
//        }
//    }
//    Log.d("headline", "no error")
//    Log.d("global", "GlobalNewsScreen: ${EverythingNews.data!!}")
//
//
//}
//
//@Composable
//fun TopHeadLines(modifier: Modifier = Modifier, headline: List<Article>, navController: NavController) {
//    Column {
//        Text(modifier = Modifier.padding(10.dp),
//            text = "Top headlines",
//            style = MaterialTheme.typography.headlineMedium,
//            fontWeight = FontWeight.ExtraBold
//        )
//
//        LazyColumn(
////        modifier
////            .padding(5.dp)
//        ) {
//            items(items = headline) { news ->
//
//                Surface(
//                    onClick = {
//                        val news1 = Uri.encode(Gson().toJson(news))
//                        navController.navigate(route = NewsNavigation.DetailScreen.name + "/$news1")
//                    },
//                    modifier = Modifier
////                    .height(200.dp)
//                        .padding(5.dp)
//                ) {
//                    Column(verticalArrangement = Arrangement.Center) {
//
//
//
//                        Card(
//                            elevation = CardDefaults.cardElevation(0.dp),
//                            modifier = Modifier
////                            .fillMaxWidth()
//                                .padding(5.dp)
//                        ) {
//                            Image(
//                                painter = rememberAsyncImagePainter(
//                                    ImageRequest.Builder(LocalContext.current)
//                                        .data(news.urlToImage)
//                                        .apply {
//                                            crossfade(true)
//                                        }
//                                        .build()
//                                ),
//                                contentDescription = "News Image",
//                                modifier = Modifier
//                                    .height(150.dp) // Adjust the height as needed
//                                    .fillMaxWidth(),
//                                contentScale = ContentScale.Crop
//                            )
//                        }
//
//                        Text(
//                            text = news.title,
//                            style = MaterialTheme.typography.labelMedium,
//                            fontWeight = FontWeight.SemiBold
//                        )
//
//                        Text(
//                            text = news.publishedAt,
//                            style = MaterialTheme.typography.labelSmall,
//                            fontWeight = FontWeight.Light
//                        )
//                    }
//                }
//            }
//        }
//    }
//}

package com.example.breakingnewsapp.NewsScreen.bottomScreens

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.breakingnewsapp.Data.Article
import com.example.breakingnewsapp.Data.TopNews
import com.example.breakingnewsapp.NavigationComponents.NewsNavigation
import com.example.breakingnewsapp.NewsScreen.BottomReal
import com.example.breakingnewsapp.NewsScreen.NewsViewModel
import com.example.breakingnewsapp.component.TopBAr
import com.example.breakingnewsapp.dataorexception.DataOrException
import com.google.gson.Gson

@Composable
fun Headline(
    modifier: Modifier = Modifier, navController: NavController,
    viewModel: NewsViewModel = hiltViewModel()
) {
    val everythingNews = produceState<DataOrException<TopNews, Boolean, Exception>>(
        initialValue = DataOrException(loading = true)
    ) {
        value = viewModel.getTopHeadlines(category = "business")
    }.value

    when {
        everythingNews.loading == true -> {
            Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }
        everythingNews.data != null -> {
            Scaffold(
                topBar = { TopBAr(navController = navController) },
                bottomBar = { BottomReal(navController = navController) }
            ) { paddingValues ->
                Column(
                    modifier
                        .padding(paddingValues)
                        .background(color = MaterialTheme.colorScheme.background)
                ) {
                    TopHeadlines(headline = everythingNews.data!!.articles, navController = navController)
                }
            }
        }
        everythingNews.e != null -> {
            Box(modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text("An error occurred: ${everythingNews.e!!.message}")
            }
        }
    }

    Log.d("Headline", "No error")
    Log.d("Global", "GlobalNewsScreen: ${everythingNews.data}")
}

@Composable
fun TopHeadlines(modifier: Modifier = Modifier, headline: List<Article>, navController: NavController) {
    Column {
        Text(
            modifier = Modifier.padding(10.dp),
            text = "Top headlines",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.ExtraBold
        )

        LazyColumn {
            items(items = headline) { news ->
                Surface(
                    onClick = {
                        val newsJson = Uri.encode(Gson().toJson(news))
                        navController.navigate("${NewsNavigation.DetailScreen.name}/$newsJson")
                    },
                    modifier = Modifier.padding(5.dp)
                ) {
                    Column(verticalArrangement = Arrangement.Center) {
                        Card(
                            elevation = CardDefaults.cardElevation(0.dp),
                            modifier = Modifier.padding(5.dp)
                        ) {
                            Image(
                                painter = rememberAsyncImagePainter(
                                    ImageRequest.Builder(LocalContext.current)
                                        .data(news.urlToImage ?: "")
                                        .apply { crossfade(true) }
                                        .build()
                                ),
                                contentDescription = "News Image",
                                modifier = Modifier
                                    .height(150.dp)
                                    .fillMaxWidth(),
                                contentScale = ContentScale.Crop
                            )
                        }

                        Text(
                            text = news.title,
                            style = MaterialTheme.typography.labelMedium,
                            fontWeight = FontWeight.SemiBold
                        )

                        Text(
                            text = news.publishedAt,
                            style = MaterialTheme.typography.labelSmall,
                            fontWeight = FontWeight.Light
                        )
                    }
                }
            }
        }
    }
}
