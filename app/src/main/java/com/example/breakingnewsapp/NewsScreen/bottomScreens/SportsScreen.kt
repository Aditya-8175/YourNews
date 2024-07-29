package com.example.breakingnewsapp.NewsScreen.bottomScreens

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
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.breakingnewsapp.Data.TopNews
import com.example.breakingnewsapp.NewsScreen.BottomReal
import com.example.breakingnewsapp.NewsScreen.MainNewsContent
import com.example.breakingnewsapp.NewsScreen.NewsViewModel
import com.example.breakingnewsapp.dataorexception.DataOrException

//@Preview(showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SportsScreen(
    modifier: Modifier = Modifier, navController: NavController = NavController(LocalContext.current),
    sportViewModel : NewsViewModel
) {

    val sportdata = produceState<DataOrException<TopNews, Boolean, Exception>>(initialValue = DataOrException(loading = true)

    ) { value = sportViewModel.getTopHeadlines("sports") }.value

    when {
        sportdata.loading == true -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                CircularProgressIndicator()
            }
        }
        sportdata.data != null -> {

            Scaffold(
                topBar = {
                    Row(
                        horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(top = 6.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "",
                            Modifier.clickable {
                                navController.popBackStack()
                            })

                        Spacer(modifier = Modifier.width(70.dp))
                        Text(text = "Sports News", fontWeight = FontWeight.ExtraBold, fontSize = 25.sp)
                    }

                },
                bottomBar = { BottomReal(navController = navController)}
            ) {

                Column(modifier = Modifier
                    .padding(it)
//                    .fillMaxSize()
                ) {

                    MainNewsContent(navController = navController, newList =  sportdata.data!!.articles)
                }

            }
        }

        sportdata.e != null -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                Text(text = "Error occur ${sportdata.e!!.message}")
            }
        }



    }


//    TopHeadLines(headline = , navController = )
}