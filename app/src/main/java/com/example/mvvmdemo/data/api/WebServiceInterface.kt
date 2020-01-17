package com.example.mvvmdemo.data.api

import com.example.mvvmdemo.data.model.Todo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WebServiceInterface {

    @GET("/todos/{id}")
    suspend fun getTodos(@Path(value = "id") id: Int): Todo

}