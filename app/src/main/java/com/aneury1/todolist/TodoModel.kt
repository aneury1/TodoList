package com.aneury1.todolist

import com.google.gson.annotations.SerializedName
import retrofit2.Call


data class BaseModel(@SerializedName("quote")
                     val title: String,
                     @SerializedName("author")
                     val author: String)
data class TodoModel(
    ///val list : Call<BaseModel>
    @SerializedName("quote")
    var quote: String,
    @SerializedName("author")
    var author: String
)
