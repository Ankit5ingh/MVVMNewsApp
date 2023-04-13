package com.ankit.mvvmnewsapp.repository

import com.ankit.mvvmnewsapp.api.RetrofitInstance
import com.ankit.mvvmnewsapp.db.ArticleDao
import com.ankit.mvvmnewsapp.models.Article
import com.ankit.mvvmnewsapp.models.NewsResponse
import retrofit2.Response
import retrofit2.http.Query

class NewsRepository(private val dao : ArticleDao) {
    suspend fun getBreakingNews(countryCode : String, pageNo:Int) : Response<NewsResponse> =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNo)

    suspend fun searchNews(searchQuery: String, pageNo:Int) : Response<NewsResponse> =
        RetrofitInstance.api.searchNews(searchQuery, pageNo)

    suspend fun upsert(article: Article) = dao.upsert(article)

    fun getSavedNews() = dao.getAllArticle()

    suspend fun deleteSavedArticle(article: Article) = dao.deleteArticle(article)
}