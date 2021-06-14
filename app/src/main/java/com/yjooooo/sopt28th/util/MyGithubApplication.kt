package com.yjooooo.sopt28th.util

import android.app.Application
import com.yjooooo.sopt28th.data.model.UserAuthStorage

class MyGithubApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        UserAuthStorage.init(this)
    }
}