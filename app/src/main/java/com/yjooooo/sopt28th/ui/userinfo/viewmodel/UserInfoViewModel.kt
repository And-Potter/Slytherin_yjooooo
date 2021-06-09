package com.yjooooo.sopt28th.ui.userinfo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class UserInfoViewModel : ViewModel() {
    private val _isLogout = MutableLiveData(false)
    val isLogout: LiveData<Boolean>
        get() = _isLogout

    fun setIsLogout(isLogout: Boolean) {
        _isLogout.value = isLogout
    }
}