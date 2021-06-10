package com.yjooooo.sopt28th.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yjooooo.sopt28th.data.api.RetrofitBuilder
import com.yjooooo.sopt28th.data.model.UserAuthStorage
import com.yjooooo.sopt28th.ui.home.model.ResponseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

class HomeViewModel : ViewModel() {
    private val _repoList = MutableLiveData<MutableList<ResponseRepository>>()
    val repoList: LiveData<MutableList<ResponseRepository>>
        get() = _repoList

    private val _userName = MutableLiveData("")
    val userName: LiveData<String> = _userName
    private val _userId = MutableLiveData("")
    val userId: LiveData<String> = _userId
    private val _imgUrl = MutableLiveData("")
    val imgUrl: LiveData<String> = _imgUrl
    private val _userCompany = MutableLiveData("")
    val userCompany: LiveData<String> = _userCompany

    fun getUserInfo() = viewModelScope.launch(Dispatchers.IO) {
        try {
            val responseUserInfo =
                RetrofitBuilder.gitHubService.getUserInfo(username = UserAuthStorage.getUserId())
            _userName.postValue(responseUserInfo.name)
            _userId.postValue(responseUserInfo.login)
            _imgUrl.postValue(responseUserInfo.avatarUrl)
            _userCompany.postValue(responseUserInfo.company)
        } catch (e: HttpException) {

        }
    }

    fun getRepository() = viewModelScope.launch(Dispatchers.IO) {
        try {
            val responseRepository =
                RetrofitBuilder.gitHubService.getRepository(username = UserAuthStorage.getUserId())
            _repoList.postValue(responseRepository.toMutableList())
        } catch (e: HttpException) {

        }
    }
}