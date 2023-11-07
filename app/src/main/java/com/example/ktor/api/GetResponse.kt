package com.example.ktor.api

import kotlinx.serialization.Serializable

@Serializable
data class GetResponse(
	val postItems : List<PostItem>
)