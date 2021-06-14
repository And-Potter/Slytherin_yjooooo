package com.yjooooo.sopt28th.ui.userinfo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yjooooo.sopt28th.data.api.RetrofitBuilder
import com.yjooooo.sopt28th.data.model.UserAuthStorage
import com.yjooooo.sopt28th.ui.userinfo.model.ResponseFollow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

class UserFollowViewModel : ViewModel() {
    private val _followList = MutableLiveData<MutableList<ResponseFollow>>()
    val followList: LiveData<MutableList<ResponseFollow>>
        get() = _followList

    fun getUserFollower() = viewModelScope.launch(Dispatchers.IO) {
        try {
            val responseFollower =
                RetrofitBuilder.gitHubService.getFollowers(UserAuthStorage.getUserId())
            _followList.postValue(responseFollower.toMutableList())
        } catch (e: HttpException) {
        }
    }

    fun getUserFollowing() = viewModelScope.launch(Dispatchers.IO) {
        try {
            val responseFollowing =
                RetrofitBuilder.gitHubService.getFollowings(UserAuthStorage.getUserId())
            _followList.postValue(responseFollowing.toMutableList())
        } catch (e: HttpException) {
        }
    }
}