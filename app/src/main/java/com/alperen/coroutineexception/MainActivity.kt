package com.alperen.coroutineexception

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val handler = CoroutineExceptionHandler{coroutineContext, throwable ->
        println("exception:"+ throwable.localizedMessage)
        }
        lifecycleScope.launch(handler){
            throw Exception("error")
        }
        lifecycleScope.launch {
            launch {
                throw Exception("")
            }
        }
    }
}