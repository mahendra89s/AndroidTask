package com.example.myapplication.data

import com.example.myapplication.model.AuthorItem
import retrofit2.http.GET

interface ApiInterface {
    @GET("list?limit=10")
    suspend fun getData() : List<AuthorItem>
}