package com.example.ktor

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.ktor.api.GetResponse
import com.example.ktor.api.PostItem
import com.example.ktor.ui.theme.KtorTheme
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.utils.EmptyContent.contentType
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.util.InternalAPI
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

val client = Client().client
class MainActivity : ComponentActivity() {
	@OptIn(DelicateCoroutinesApi::class)
	@SuppressLint("CoroutineCreationDuringComposition")
	override fun onCreate(savedInstanceState : Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			KtorTheme {
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background,
				) {
					GlobalScope.launch {
						withContext(Dispatchers.IO) {
							val response = client.get("https://jsonplaceholder.typicode.com/posts"){
								contentType(ContentType.Application.Json)
							}.body<List<PostItem>>()

							println("myPrint $response")
						}
					}
				}
			}
		}
	}
}


