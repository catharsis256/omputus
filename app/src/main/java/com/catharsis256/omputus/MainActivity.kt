package com.catharsis256.omputus

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val reset = findViewById<View>(R.id.reset)
        Log.d("COMMONZ", "rest found")
    }
}
