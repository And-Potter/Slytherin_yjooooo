package com.yjooooo.sopt28th

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LifeCycle", "Home_onCreate")
        setContentView(R.layout.activity_home)
    }

    override fun onStart() {
        super.onStart()
        Log.d("LifeCycle", "Home_onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifeCycle", "Home_onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifeCycle", "Home_onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycle", "Home_onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycle", "Home_onDestroy")
    }
}