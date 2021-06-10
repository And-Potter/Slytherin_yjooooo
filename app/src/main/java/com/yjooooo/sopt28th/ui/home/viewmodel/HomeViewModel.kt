package com.yjooooo.sopt28th.ui.home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yjooooo.sopt28th.data.api.RetrofitBuilder
import com.yjooooo.sopt28th.data.model.UserAuthStorage
import com.yjooooo.sopt28th.ui.home.model.RepoData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

class HomeViewModel : ViewModel() {
    private val _repoList = MutableLiveData<MutableList<RepoData>>()
    val repoList: LiveData<MutableList<RepoData>>
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
            Log.d("tag_userInfo", responseUserInfo.name)
            Log.d("tag_userInfo", responseUserInfo.login)
            _userName.postValue(responseUserInfo.name)
            _userId.postValue(responseUserInfo.login)
            _imgUrl.postValue(responseUserInfo.avatarUrl)
            _userCompany.postValue(responseUserInfo.company)
        } catch (e: HttpException) {

        }
    }

    fun addRepoList() {
        _repoList.value = dummyRepoList.toMutableList()
    }

    private val dummyRepoList = listOf(
        RepoData("repoName1", "repoInfo1", "kotlin"),
        RepoData("repoName2", "repoInfo2", "c++"),
        RepoData("repoName3", "repoInfo3", "java"),
        RepoData("repoName4", "repoInfo4", "kotlin"),
        RepoData("repoName5", "repoInfo5", "kotlin"),
        RepoData("repoName6", "repoInfo6", "kotlin"),
        RepoData("repoName7", "repoInfo7", "kotlin"),
        RepoData("repoName8", "repoInfo8", "kotlin"),
        RepoData("repoName9", "repoInfo9", "kotlin")
    )
}