package com.yjooooo.sopt28th.ui.userinfo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yjooooo.sopt28th.data.api.RetrofitBuilder
import com.yjooooo.sopt28th.data.model.UserAuthStorage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

class UserInfoViewModel : ViewModel() {
    private val _isLogout = MutableLiveData(false)
    val isLogout: LiveData<Boolean> = _isLogout

    private val _userName = MutableLiveData("")
    val userName: LiveData<String> = _userName
    private val _userId = MutableLiveData("")
    val userId: LiveData<String> = _userId
    private val _imgUrl = MutableLiveData("")
    val imgUrl: LiveData<String> = _imgUrl

    fun setIsLogout(isLogout: Boolean) {
        _isLogout.value = isLogout
    }

    fun getUserInfo() = viewModelScope.launch(Dispatchers.IO) {
        try {
            val responseUserInfo =
                RetrofitBuilder.gitHubService.getUserInfo(username = UserAuthStorage.getUserId())
            _userName.postValue(responseUserInfo.name)
            _userId.postValue(responseUserInfo.login)
            _imgUrl.postValue(responseUserInfo.avatarUrl)
        } catch (e: HttpException) {
        }
    }
}