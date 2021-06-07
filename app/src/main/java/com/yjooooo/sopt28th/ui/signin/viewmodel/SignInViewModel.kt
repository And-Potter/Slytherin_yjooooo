package com.yjooooo.sopt28th.ui.signin.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yjooooo.sopt28th.data.api.RetrofitBuilder
import com.yjooooo.sopt28th.data.model.RequestSignIn
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException

class SignInViewModel : ViewModel() {
    private val _nickname = MutableLiveData<String>()
    val nickname: LiveData<String>
        get() = _nickname

    val email = MutableLiveData<String>("")
    val password = MutableLiveData<String>("")

    private val _isSignIn = MutableLiveData<Boolean>()
    val isSignIn: LiveData<Boolean>
        get() = _isSignIn

    private val _isUserInfoNotNull = MutableLiveData<Boolean>()
    val isUserInfoNotNull: LiveData<Boolean>
        get() = _isUserInfoNotNull

    fun requestSignIn() = viewModelScope.launch(Dispatchers.IO) {
        try {
            val responseSignIn = RetrofitBuilder.loginService.postSignIn(
                RequestSignIn(
                    email = requireNotNull(email.value),
                    password = requireNotNull(password.value)
                )
            )
            _nickname.postValue(responseSignIn.data.userNickname)
            _isSignIn.postValue(true)
        } catch (e: HttpException) {
            _isSignIn.postValue(false)
        }
    }

    fun checkIsNotNull() {
        _isUserInfoNotNull.value = !email.value.isNullOrEmpty() && !password.value.isNullOrEmpty()
    }

    fun autoSetUserInfo(id:String, pw:String){
        email.value = id
        password.value = pw
    }
}