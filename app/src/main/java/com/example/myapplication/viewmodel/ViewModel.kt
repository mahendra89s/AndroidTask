package com.example.myapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.Repository
import com.example.myapplication.model.AuthorItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class ViewModel @Inject constructor(
    val repository: Repository
) : ViewModel(){

    private val _authorData : MutableLiveData<List<AuthorItem>?> = MutableLiveData()
    val authorData : LiveData<List<AuthorItem>?> = _authorData

    fun getAuthorData(){
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getData()
            _authorData.postValue(response)
        }
    }
}