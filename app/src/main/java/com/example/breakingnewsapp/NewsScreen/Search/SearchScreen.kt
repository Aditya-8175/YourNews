package com.example.breakingnewsapp.NewsScreen.Search

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.breakingnewsapp.NavigationComponents.NewsNavigation
import com.example.breakingnewsapp.R
import com.example.breakingnewsapp.widgets.SearchForm

@Preview(showSystemUi = true, showBackground = true)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen( navController: NavController = NavController(LocalContext.current)) {

            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
//                modifier = Modifier.padding(30.dp)
            ) {
                TopAppBar(title = { Text(text = "Search News") },
                    navigationIcon = {
                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "",
                            modifier = Modifier.clickable {
                                navController.popBackStack()
                            })
                    }
                )

                SearchForm() { news ->

                    navController.navigate(NewsNavigation.HomeScreen.name + "/$news")
                }
                Image(painter = painterResource(id = R.drawable.empty), contentDescription = "",)
            }



//        SearchForm() { city ->
//            navController.navigate(NewsNavigation.HomeScreen.name + "/$city")
//
//        }



}

