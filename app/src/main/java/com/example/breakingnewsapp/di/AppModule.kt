package com.example.breakingnewsapp.di

import com.example.breakingnewsapp.network.NewsApi
import com.example.breakingnewsapp.repository.NewsRepository
import com.example.breakingnewsapp.utils.constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun provideQuizRepository(api: NewsApi) = NewsRepository(api)

    @Singleton
    @Provides
    fun provideQuestionApi(): NewsApi {
        return Retrofit.Builder()
            .baseUrl(constants.base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)

    }


}