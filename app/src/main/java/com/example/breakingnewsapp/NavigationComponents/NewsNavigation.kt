package com.example.breakingnewsapp.NavigationComponents

import java.io.IOException

enum class NewsNavigation{
    HomeScreen,
    DetailScreen,
    SplashScreen,
    SearchScreen,
    Headline,
    SportsScreen,
    Entertaintment


//    companion object {
//        fun fromRoute(route:String?): NewsNavigation
//            = when(route?.substringBefore("/")){
//                SplashScreen.name -> SplashScreen
//                HomeScreen.name -> HomeScreen
//                DetailScreen.name -> DetailScreen
//                null -> HomeScreen
//
//                else -> throw IOException("Route $route is not recognized")
//            }
//
//    }
}