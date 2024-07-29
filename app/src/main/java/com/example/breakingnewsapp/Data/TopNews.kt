package com.example.breakingnewsapp.Data

data class TopNews(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)