package com.example.breakingnewsapp.NavigationComponents

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.breakingnewsapp.NewsScreen.HomeScreen
import com.example.breakingnewsapp.NewsScreen.NewsViewModel
import com.example.breakingnewsapp.NewsScreen.Search.SearchScreen
import com.example.breakingnewsapp.NewsScreen.SplashScreen
import com.example.breakingnewsapp.NewsScreen.bottomScreens.Entertaintment
import com.example.breakingnewsapp.NewsScreen.bottomScreens.Headline
import com.example.breakingnewsapp.NewsScreen.bottomScreens.SportsScreen
import com.example.newsapp.NewsScreen.DetailScreen

// Navigation component

@Composable
fun NewsScreen() {
    val navController = rememberNavController()
//    NavHost(navController = navController, startDestination = NewsNavigation.HomeScreen.name) {
    NavHost(navController = navController, startDestination = NewsNavigation.SplashScreen.name) {

                composable(NewsNavigation.SplashScreen.name) {
//            val newsViewModel = hiltViewModel<NewsViewModel>()
            SplashScreen(navController)
        }

        val route = NewsNavigation.HomeScreen.name
        composable(
            "$route/{city}",
            arguments = listOf(navArgument(name = "city") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("city")?.let { city ->
//                NewsNavigation.DetailScreen(
//                    navController, it
//                )
                val newsViewModel = hiltViewModel<NewsViewModel>()
                HomeScreen(
                    newsViewModel = newsViewModel,
                    navController = navController,
//                    city = city ,
                    search = city )
            }
        }

        composable(NewsNavigation.SearchScreen.name){
//            val  viewModel = hiltViewModel<SearchViewModel>()
            SearchScreen(navController = navController)
        }
//        composable(NewsNavigation.HomeScreen.name) {
//            val newsViewModel = hiltViewModel<NewsViewModel>()
//            HomeScreen(navController, newsViewModel)
//
//        }
        

        composable(
            NewsNavigation.DetailScreen.name + "/{news}",
            arguments = listOf(navArgument(name = "news") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("news")?.let {
//                NewsNavigation.DetailScreen(
//                    navController, it
//                )
                val viewModel = hiltViewModel<NewsViewModel>()
                DetailScreen(viewModel = viewModel,
                    navController = navController,
                    city = it, search = it)
            }
        }


        composable(NewsNavigation.Headline.name){
//            val  viewModel = hiltViewModel<SearchViewModel>()
            Headline(navController = navController, viewModel = hiltViewModel<NewsViewModel>())
        }

        composable(NewsNavigation.SportsScreen.name){
//            val  viewModel = hiltViewModel<SearchViewModel>()
            SportsScreen(navController = navController, sportViewModel = hiltViewModel<NewsViewModel>())
        }
        composable(NewsNavigation.Entertaintment.name){
//            val  viewModel = hiltViewModel<SearchViewModel>()
            Entertaintment(navController = navController, entertainment = hiltViewModel<NewsViewModel>())
        }
    }
}