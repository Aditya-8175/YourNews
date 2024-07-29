@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.newsapp.NewsScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.breakingnewsapp.Data.Article
import com.example.breakingnewsapp.NewsScreen.NewsViewModel
import com.google.gson.Gson

@Composable
fun DetailScreen(navController: NavController, viewModel: NewsViewModel, city: String, search: String) {
//val newsList = getNews().filter { news ->
//    news.id == newsId
//}
//    val newList = viewModel.getTopHeadlines(city).data?.articles?.get(0)
    val newsItem = Gson().fromJson(search, Article::class.java)
   Column {
       TopAppBar(

           title = { Text(text = "Detail News", style = MaterialTheme.typography.headlineLarge) },
           modifier = Modifier
               .background(color = MaterialTheme.colorScheme.background)
               .fillMaxWidth()
//                .background(Color.Blue)
           ,
           navigationIcon = {
               Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "",
                   modifier = Modifier.clickable {
                       navController.popBackStack()
                   })
           }

       )


       Box(modifier = Modifier
           .fillMaxWidth()
           .height(200.dp)
           ){
           Image(
               painter = rememberAsyncImagePainter(
                   ImageRequest.Builder(LocalContext.current)
                       .data(newsItem.urlToImage)
                       .build()
               ),
               contentDescription = "News Image",
               modifier = Modifier.fillMaxSize()
           )
       }

//       val scrollableState = remember {
//           mutableStateOf(rememberScrollState())
//       }

       Surface(
           modifier = Modifier
               .fillMaxHeight()
               .fillMaxWidth()
       ) {
           Column(
               horizontalAlignment = Alignment.CenterHorizontally,
               verticalArrangement = Arrangement.Top
           ) {

//               newsRow(newsItem = newsList.first())
               androidx.compose.foundation.layout.Spacer(
                   modifier = Modifier.height(
                       8.dp
                   )
               )
               Divider()

               Card(
                   modifier = Modifier
                       .padding(12.dp)
                       .fillMaxWidth()
                       ,
                   shape = RoundedCornerShape(corner = CornerSize(14.dp)),
                   elevation = CardDefaults.cardElevation(5.dp),

                   ) {
                   Row(
                       horizontalArrangement = Arrangement.Start,
                       verticalAlignment = Alignment.CenterVertically,
                       modifier = Modifier.padding(12.dp)
                   ) {


                       // category - desc - author = date

                       Column( modifier = Modifier.padding(6.dp), verticalArrangement = Arrangement.Top) {

                           Text(
                               text = "Title: ${newsItem.title}",
                               style = MaterialTheme.typography.headlineLarge ,fontWeight = FontWeight.Bold
                           )

                           Text(
                               text = "Description: ${newsItem.description}",
                               style = MaterialTheme.typography.headlineMedium,
                           )
                           Text(
                               text = "Author: ${newsItem.author}",
                               style = MaterialTheme.typography.labelSmall
                           )
                           Text(
                               text = "Author: ${newsItem.publishedAt}",
                               style = MaterialTheme.typography.labelSmall
                           )


                       }

                   }
               }
           }


       }
   }


}