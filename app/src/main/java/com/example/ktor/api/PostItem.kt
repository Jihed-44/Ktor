package com.example.ktor.api

import kotlinx.serialization.Serializable

@Serializable
data class PostItem(
	val body : String = "",
    val id : Int = 0,
    val title : String = "",
    val userId : Int = 0,
    val something : Boolean? = null
)

