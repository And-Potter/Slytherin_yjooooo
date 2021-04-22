package com.yjooooo.sopt28th.ui.home

import android.os.Bundle
import android.util.Log
import com.yjooooo.sopt28th.R
import com.yjooooo.sopt28th.databinding.ActivityHomeBinding
import com.yjooooo.sopt28th.ui.base.BindingActivity
import com.yjooooo.sopt28th.util.StatusBarUtil

class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.setStatusBar(this,resources.getColor(R.color.main_color_purple, null))
        Log.d("LifeCycle", "Home_onCreate")
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