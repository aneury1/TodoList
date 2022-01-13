package com.aneury1.todolist

public data class Flags(
    val nsfw: Boolean,
    val religious: Boolean,
    val political :Boolean,
    val racist : Boolean,
    val sexist : Boolean,
    val explicit: Boolean
)

data class Joke(
    val error: Boolean,
    val amount: Int,
    var category: String,
    var delivery: String,
    val type: Int,
    val joke: String,
    val setup: String,
    /////val flags: Flags,
    val id :Int,
    val safe: Boolean,
    val lang: String,
    val twopart: String
)
