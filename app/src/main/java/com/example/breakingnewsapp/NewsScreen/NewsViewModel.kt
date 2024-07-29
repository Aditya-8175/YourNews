package com.example.breakingnewsapp.NewsScreen

import androidx.lifecycle.ViewModel
import com.example.breakingnewsapp.Data.TopNews
import com.example.breakingnewsapp.dataorexception.DataOrException
import com.example.breakingnewsapp.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val repository: NewsRepository) : ViewModel() {

    // Everything type news
    suspend fun getNewsData(specificNews: String): DataOrException<TopNews, Boolean, Exception> {
        return repository.getAllNews(specificQuery = specificNews)
    }

    // top headlines
    suspend fun getTopHeadlines(
//        country: String,
        category: String
    ): DataOrException<TopNews, Boolean, Exception> {
        return repository.getTopNews(
//            countryQuery = country,
            category = category
        )
    }

    suspend fun getHeadline() : DataOrException<TopNews, Boolean,Exception> {
        return repository.getHeadline()
    }


    // Function to run both operations in parallel

//    suspend fun getNewsAndHeadlines(specificNews: String, category: String): Pair<DataOrException<TopNews, Boolean, Exception>, DataOrException<TopNews, Boolean, Exception>> {
//        return coroutineScope {
//            val newsDataDeferred = async { getNewsData(specificNews) }
//            val topHeadlinesDeferred = async { getTopHeadlines(
////                country,
//                category) }
//
//            val newsData = newsDataDeferred.await()
//            val topHeadlines = topHeadlinesDeferred.await()
//
//            Pair(newsData, topHeadlines)
//        }
//    }

//    val data: MutableState<DataOrException<TopNews,
//            Boolean, Exception>> = mutableStateOf(
//        DataOrException(null, true, Exception("")) )

//    init {
//        loadNews()
//    }
//
//    private fun loadNews() {
//        getAllNews("apple")
//    }
//
//    private fun getAllNews(specificNews: String) {
//        viewModelScope.launch {
//            if (specificNews.isNotEmpty()) return@launch
//            data.value.loading = true
//            data.value = repository.getAllNews(specificQuery = specificNews)
//           if (data.value.data.toString().isNotEmpty()) data.value.loading = false
//        }
//        Log.d("GET", "getAllNews: ${data.value.data.toString()}")
//
//    }
//    fun getTotalQuestionCount(): Int {
//        return data.value.data?.toMutableList()?.size!!
//    }

}



