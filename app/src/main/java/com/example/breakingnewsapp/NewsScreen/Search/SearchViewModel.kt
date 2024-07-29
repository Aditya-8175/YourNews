package com.example.breakingnewsapp.NewsScreen.Search

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.breakingnewsapp.Data.TopNews
import com.example.breakingnewsapp.dataorexception.DataOrException
import com.example.breakingnewsapp.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: NewsRepository):
    ViewModel() {
    val data: MutableState<DataOrException<TopNews, Boolean, Exception>>
            = mutableStateOf(DataOrException(null, true,Exception("")))

    suspend fun getTopHeadlines(
//        country: String,
        category: String): DataOrException<TopNews, Boolean, Exception>{
        return repository.getTopNews(
//            countryQuery = country,
            category =category )
    }

}