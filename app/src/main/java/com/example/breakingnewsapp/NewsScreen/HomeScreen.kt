package com.example.breakingnewsapp.NewsScreen

import android.net.Uri
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.os.BuildCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.breakingnewsapp.Data.Article
import com.example.breakingnewsapp.Data.TopNews
import com.example.breakingnewsapp.NavigationComponents.NewsNavigation
import com.example.breakingnewsapp.NewsScreen.bottomScreens.TopHeadlines
import com.example.breakingnewsapp.R
import com.example.breakingnewsapp.component.TopBAr
import com.example.breakingnewsapp.dataorexception.DataOrException
import com.google.gson.Gson


//@Preview(showBackground = true,
//    device = "id:Nexus One", wallpaper = Wallpapers.BLUE_DOMINATED_EXAMPLE
//)
@Composable
fun HomeScreen(
    navController: NavController = NavController(LocalContext.current),
    newsViewModel: NewsViewModel = hiltViewModel(),
//    viewModel: SearchViewModel = hiltViewModel(),
//    city: String = "in",
    search: String = "trending"

) {


//    Log.d("Search", city)

//    val searchNews = search.ifBlank { "everything" }
    val searchNews = search

//    val currCountry = city.ifBlank { "in" }
//    val currCountry = city.ifBlank { "in" }

//    val NewsData = produceState<DataOrException<TopNews, Boolean, Exception>>(
//        initialValue = DataOrException(loading = true)
//    ) { value = newsViewModel.getTopHeadlines(category = "business") }.value

    val EverythingNews = produceState<DataOrException<TopNews, Boolean, Exception>>(
        initialValue = DataOrException(loading = true)
    ) { value = newsViewModel.getNewsData(specificNews = searchNews) }.value

//    val Headline= produceState<DataOrException<TopNews, Boolean, Exception>>(
//        initialValue = DataOrException(loading = true)
//    ) { value = newsViewModel.getHeadline() }.value
    
//    val NewsState = produceState(initialValue = Pair(
//        DataOrException<TopNews, Boolean, Exception>(loading = true ),
//        DataOrException<TopNews, Boolean, Exception> (loading = true)
//    ) ) {
//        value = newsViewModel.getNewsAndHeadlines(searchNews,
////            currCountry,
//            category = "business" )
//    }.value

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center, modifier = Modifier.background(color = MaterialTheme.colorScheme.background)
    ) {

//        if (NewsData.loading == true )
//        CircularProgressIndicator(modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
//        else if (NewsData.data != null) {

        if (EverythingNews.loading == true)
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                CircularProgressIndicator()
            }
        else if (EverythingNews.data != null) {
//
//        if (EverythingNews.loading ==  true && Headline.loading == true)
//            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
//                CircularProgressIndicator()
//            }
//        else if (EverythingNews.data != null && Headline.data != null) {


//        if (NewsData.loading == true && EverythingNews.loading == true)
//            CircularProgressIndicator(modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
//        else if (NewsData.data != null && EverythingNews.data != null) {


//        if (NewsState.first.loading == true && NewsState.first.loading == true)
//            CircularProgressIndicator(modifier = Modifier.align(alignment = Alignment.CenterHorizontally))
//        else if (NewsState.first.data != null && NewsState.first.data != null) {
////        Text(text = "NewsData ${NewsData.data!!.articles}")

//            TopHeadLines(headline = NewsState.second.data!!.articles, navController = navController)

            Scaffold(
                topBar = { TopBAr(navController = navController) },
                bottomBar = {
                    BottomReal( navController = navController)
                   }
            ) { innerpadding ->
//                Log.d("TAG", "HomeScreen: ${NewsData.data!!.totalResults}")
//                Log.d("TAG", "HomeScreen: ${NewsState.first.data!!.totalResults}")

                Column(modifier = Modifier.padding(innerpadding), verticalArrangement = Arrangement.Center) {

//                    customRowContent(headline = Headline.data!!.articles, navController = navController )

//                    TopHeadlines(headline = EverythingNews.data!!.articles, navController = navController)
//TopHeadlines(headline = NewsData.data!!.articles, navController = navController)
                    MainNewsContent(
                        navController = navController,
                        newList = EverythingNews.data!!.articles

                    )

                }
            }

//            Log.d("adi", "HomeScreen: ${NewsData.data!!.articles}")
//            Log.d("adi", "HomeScreen: ${EverythingNews.data!!.articles}")

        }


    }

}



@Composable
fun MainNewsContent(
    navController: NavController,
    newList: List<Article>
//                    newList: List<TopNews>
) {

    Column {
        LazyColumn {
            items(items = newList) { it ->
//                Text(text = it)
                newsRow(newsItem = it) {

                    val news = Uri.encode(Gson().toJson(it))
                    navController.navigate(route = NewsNavigation.DetailScreen.name + "/$news")
                }

            }
        }

    }

}

@Composable
fun newsRow(newsItem: Article, onItemClick: (Article) -> Unit = {}) {

    var expanded by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth()
            .clickable {
                onItemClick(newsItem)
            },
        shape = RoundedCornerShape(corner = CornerSize(14.dp)),
        elevation = CardDefaults.cardElevation(0.dp),

        ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(12.dp)
        ) {
            Card(
                elevation = CardDefaults.cardElevation(0.dp),
                shape = CircleShape,
                modifier = Modifier
                    .size(100.dp)
                    .padding(5.dp)

            ) {
                    Image(
                        painter = rememberAsyncImagePainter(
                            ImageRequest.Builder(LocalContext.current)
                                .data(newsItem.urlToImage)
                                .apply {
                                    crossfade(true)
                                    transformations(CircleCropTransformation())
                                }
                                .build()
                        ),
                        contentDescription = "News Image",
                        modifier = Modifier.size(100.dp)
                    )

        }
            // category - desc - author = date

            Column(modifier = Modifier.padding(6.dp), verticalArrangement = Arrangement.Top) {


                Text(
                    text = newsItem.title,
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    text = "by ${newsItem.author}",
                    style = MaterialTheme.typography.labelMedium
                )

                AnimatedVisibility(visible = expanded) {
                    Column {
                        Text(buildAnnotatedString {
                            withStyle(
                                style = SpanStyle(
                                    color = Color.DarkGray,
                                    fontSize = 13.sp
                                )
                            ) {
                                append("Description: ")
                            }
                            withStyle(
                                style = SpanStyle(
                                    color = Color.DarkGray,
                                    fontSize = 13.sp
                                )
                            ) {
                                append(newsItem.description)
                            }

                        })

                        Text(
                            text = "Author: ${newsItem.author}",
                            style = MaterialTheme.typography.labelSmall
                        )
                        Text(
                            text = "Date: ${newsItem.publishedAt}",
                            style = MaterialTheme.typography.labelSmall
                        )


                    }

                }

                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp,
                    contentDescription = "Arrow", modifier = Modifier
                        .size(25.dp)
                        .clickable {
                            expanded = !expanded
                        }, tint = Color.DarkGray
                )

            }


    }
}
    }


@Composable
fun customRowContent(modifier: Modifier = Modifier, headline:List<Article>,navController: NavController)
{

    Row {
        LazyRow {
            items(items = headline) { it ->
//                Text(text = it)
                newsRow(newsItem = it) {

                    val news = Uri.encode(Gson().toJson(it))
                    navController.navigate(route = NewsNavigation.DetailScreen.name + "/$news")
                }

            }
        }

    }

}



//@Composable
//fun BlurredBackground(content: @Composable () -> Unit) {
//    val context = LocalContext.current
//    val decorView = (context as Activity).window.decorView
//    Box {
//        AndroidView(
//            factory = {
////                BlurView(context).apply {
////                    setupWith(decorView.rootView)
////                        .setBlurAlgorithm(RenderScriptBlur(context))
//                        .setBlurRadius(10f) // Adjust blur radius as needed
//                        .setHasFixedTransformationMatrix(true)
//                }
//            }
//        )
//        content()
//    }
//}

