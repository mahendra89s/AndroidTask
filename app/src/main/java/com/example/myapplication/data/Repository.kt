package com.example.myapplication.data

import com.example.myapplication.model.AuthorItem
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getData() : List<AuthorItem>?
}