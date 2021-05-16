package com.yjooooo.sopt28th.ui.signup.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yjooooo.sopt28th.data.api.RetrofitBuilder
import com.yjooooo.sopt28th.data.model.RequestSignUp
import kotlinx.coroutines.launch
import retrofit2.HttpException

class SignUpViewModel : ViewModel() {
    val nickname = MutableLiveData<String>("")
    val email = MutableLiveData<String>("")
    val password = MutableLiveData<String>("")

    private val _isSignUp = MutableLiveData<Boolean>()
    val isSignUp: LiveData<Boolean>
        get() = _isSignUp

    private val _isUserInfoNotNull = MutableLiveData<Boolean>()
    val isUserInfoNotNull: LiveData<Boolean>
        get() = _isUserInfoNotNull

    fun requestSignUp() = viewModelScope.launch {
        try {
            RetrofitBuilder.loginService.postSignUp(
                RequestSignUp(
                    birth = "none",
                    email = email.value!!,
                    nickname = nickname.value!!,
                    password = password.value!!,
                    phone = "none",
                    sex = "none"
                )
            )
            _isSignUp.postValue(true)
        } catch (e: HttpException) {
            _isSignUp.postValue(false)
        }
    }

    fun checkIsNotNull() {
        _isUserInfoNotNull.value =
            !nickname.value.isNullOrEmpty() && !email.value.isNullOrEmpty() && !password.value.isNullOrEmpty()
    }
}