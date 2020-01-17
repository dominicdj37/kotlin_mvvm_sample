package com.example.mvvmdemo.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmdemo.data.api.ApiFactory
import com.example.mvvmdemo.data.api.WebServiceInterface
import com.example.mvvmdemo.data.model.Todo

object TodoRepository {

    private var apiFactory :WebServiceInterface = ApiFactory.create()

    suspend fun getSpecificTodo(id: Int) = apiFactory.getTodos(id)
}