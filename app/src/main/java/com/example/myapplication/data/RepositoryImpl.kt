package com.example.myapplication.data

import com.example.myapplication.model.AuthorItem
import retrofit2.Retrofit
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    retrofit: Retrofit
) : Repository {

    private val apiService by lazy {
        retrofit.create(ApiInterface::class.java)
    }

    override suspend fun getData(): List<AuthorItem>? = kotlin.runCatching {
        return@runCatching apiService.getData()
    }.onFailure {
        it.printStackTrace()
    }.getOrNull()
}