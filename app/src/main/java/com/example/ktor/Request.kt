package com.example.ktor

import android.util.Log
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

suspend fun sendRequest(){
	val response: HttpResponse = client.request("https://jsonplaceholder"){
		method = HttpMethod.Get
	}
	Log.d("my response", "${response.status}")
}