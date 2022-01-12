package com.aneury1.todolist

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject



object Retrofit2 {

    var URL = "https://gist.githubusercontent.com/aneury1/ae5905230f06a2616f57c31a0cff1c0c/raw/4b8d3b2d7536ce2d1f428432072ef4d390747e28/"

    fun getRetrofit2(): Retrofit {
       return Retrofit
           .Builder()
           .baseUrl(URL)
           .addConverterFactory(GsonConverterFactory.create())
           .build()
    }

    fun getUrl(): String{
        return URL
    }
}