package com.aneury1.todolist

import retrofit2.Response
import retrofit2.http.GET

interface TodoEndpoint {

    @GET("/quotes.json")
    fun getAllTodo(): Response<List<TodoModel>>


    @GET("/joke/Any?lang=es")
    suspend fun getOneJoke(): Response<Joke>
}