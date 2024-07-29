package com.example.breakingnewsapp.network

import com.example.breakingnewsapp.Data.TopNews
import com.example.breakingnewsapp.utils.constants
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface NewsApi {
    @GET("v2/everything")
    suspend fun getApi(
        @Query("q")
        query: String = "everything",
        @Query("sortBy")
        sortBy: String = "popularity",
        @Query("apiKey")
        apiKey: String = constants.NEWS_API_KEY
    ): TopNews

    @GET("v2/top-headlines")
    suspend fun getApiTopHeadlines(
        @Query("country")
        query: String = "in",
        @Query("category")
        category: String ,
        @Query("sortBy")
        sortBy: String = "popularity",
        @Query("apiKey")
        apiKey: String = constants.NEWS_API_KEY
    ): TopNews

    @GET("v2/top-headlines")
    suspend fun getApiHeadlines(
        @Query("sortBy")
        sortBy: String = "popularity",
        @Query("apiKey")
        apiKey: String = constants.NEWS_API_KEY
    ): TopNews
}