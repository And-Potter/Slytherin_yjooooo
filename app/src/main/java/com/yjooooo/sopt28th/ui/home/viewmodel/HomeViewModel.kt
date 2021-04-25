package com.yjooooo.sopt28th.ui.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yjooooo.sopt28th.ui.home.model.RepoData

class HomeViewModel : ViewModel() {
    private val _repoList = MutableLiveData<MutableList<RepoData>>()
    val repoList: LiveData<MutableList<RepoData>>
        get() = _repoList

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