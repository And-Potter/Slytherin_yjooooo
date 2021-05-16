package com.yjooooo.sopt28th.ui.signup.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.yjooooo.sopt28th.R
import com.yjooooo.sopt28th.databinding.ActivitySignUpBinding
import com.yjooooo.sopt28th.ui.base.BindingActivity
import com.yjooooo.sopt28th.ui.signup.viewmodel.SignUpViewModel
import com.yjooooo.sopt28th.util.StatusBarUtil
import com.yjooooo.sopt28th.util.toastMessageUtil

class SignUpActivity : BindingActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
    private val signUpViewModel: SignUpViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LifeCycle", "SignUp_onCreate")
        StatusBarUtil.setStatusBar(this, resources.getColor(R.color.white, null))
        binding.signUpViewModel = signUpViewModel
        binding.lifecycleOwner = this
        setIsUserInfoNotNullObserve()
        setIsSignUpObserve()
    }

    override fun onStart() {
        super.onStart()
        Log.d("LifeCycle", "SignUp_onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifeCycle", "SignUp_onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifeCycle", "SignUp_onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycle", "SignUp_onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycle", "SignUp_onDestroy")
    }

    private fun setIsUserInfoNotNullObserve() {
        signUpViewModel.isUserInfoNotNull.observe(this) { isUserInfoNotNull ->
            if (isUserInfoNotNull) {
                signUpViewModel.requestSignUp()
            } else {
                toastMessageUtil("이름, 아이디, 비밀번호를 모두 입력해주세요.")
            }
        }
    }

    private fun setIsSignUpObserve() {
        signUpViewModel.isSignUp.observe(this) { isSignUp ->
            if (isSignUp) {
                toastMessageUtil("${signUpViewModel.nickname}님 회원가입 되셨습니다.")
                val intent = Intent()
                with(intent) {
                    putExtra("id", signUpViewModel.email.value.toString())
                    putExtra("pw", signUpViewModel.password.value.toString())
                }
                setResult(Activity.RESULT_OK, intent)
                finish()
            } else {
                toastMessageUtil("올바른 정보를 입력해주세요.")
            }
        }
    }

}