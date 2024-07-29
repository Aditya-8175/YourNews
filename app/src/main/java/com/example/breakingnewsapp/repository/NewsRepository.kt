package com.example.breakingnewsapp.repository

import com.example.breakingnewsapp.Data.TopNews
import com.example.breakingnewsapp.dataorexception.DataOrException
import com.example.breakingnewsapp.network.NewsApi
import javax.inject.Inject

class NewsRepository @Inject constructor(private val api: NewsApi) {
//    private val dataOrException = DataOrException<ArrayList<Article>,
//            Boolean, Exception>()

    suspend fun getAllNews(specificQuery: String): DataOrException<TopNews, Boolean, Exception> {
        val response = try {
            api.getApi(query = specificQuery)
//            dataOrException.loading = true
//            val response: TopNews = api.getApi()
//            dataOrException.data = ArrayList(response.articles)
//            if (dataOrException.data.toString().isNotEmpty()) dataOrException.loading = false

        }catch (exception: Exception) {
//            dataOrException.e = exception
//            Log.d("Exc", "getAllQuestions: ${dataOrException.e!!.localizedMessage}")
            return DataOrException(e = exception)

        }
        return DataOrException(data = response)


    }

    suspend fun getTopNews(
//        countryQuery: String,
        category: String): DataOrException<TopNews, Boolean, Exception> {
        val  response = try {
            api.getApiTopHeadlines(
//                query = countryQuery,
                category = category)
        } catch (e: Exception){
            return DataOrException(e = e)
        }
        return DataOrException(data = response)
    }

    suspend fun getHeadline():DataOrException<TopNews, Boolean, Exception> {
        val response = try {
            api.getApiHeadlines()
        }catch (e:Exception) {
            return DataOrException(e = e)
        }
        return DataOrException(data = response)
    }

}