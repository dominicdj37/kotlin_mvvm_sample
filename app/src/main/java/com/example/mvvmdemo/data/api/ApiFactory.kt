package com.example.mvvmdemo.data.api

import com.example.mvvmdemo.core.Constants
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private fun getClient(): Retrofit = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()

    fun create(): WebServiceInterface = getClient().create(WebServiceInterface::class.java)
}