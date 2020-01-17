package com.example.mvvmdemo.data.repository

import com.example.mvvmdemo.data.api.ApiFactory
import com.example.mvvmdemo.data.api.WebServiceInterface

object TodoRepository {

    private var apiFactory :WebServiceInterface = ApiFactory.create()

    suspend fun getSpecificTodo(id: Int) = apiFactory.getTodo(id)
}