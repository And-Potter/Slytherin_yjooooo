package com.yjooooo.sopt28th.ui.userinfo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yjooooo.sopt28th.data.api.RetrofitBuilder
import com.yjooooo.sopt28th.data.model.UserAuthStorage
import com.yjooooo.sopt28th.ui.userinfo.model.ResponseOrganization
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

class UserOrganizationViewModel : ViewModel() {
    private val _organizationList = MutableLiveData<MutableList<ResponseOrganization>>()
    val organizationList: LiveData<MutableList<ResponseOrganization>>
        get() = _organizationList

    fun getUserOrganization() = viewModelScope.launch(Dispatchers.IO) {
        try {
            val responseOrganization =
                RetrofitBuilder.gitHubService.getOrganization(UserAuthStorage.getUserId())
            _organizationList.postValue(responseOrganization.toMutableList())
        } catch (e: HttpException) {
        }
    }
}