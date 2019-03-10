package com.catharsis256.omputus

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

class MainActivity : AppCompatActivity() {

    private var buttonManager : ButtonManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonManager = ButtonManager().apply {
            init {
                findViewById(it) as? View
            }
        }

    }
}
