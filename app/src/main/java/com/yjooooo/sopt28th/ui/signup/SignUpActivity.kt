package com.yjooooo.sopt28th.ui.signup

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.yjooooo.sopt28th.R
import com.yjooooo.sopt28th.databinding.ActivitySignUpBinding
import com.yjooooo.sopt28th.ui.base.BindingActivity
import com.yjooooo.sopt28th.util.StatusBarUtil
import com.yjooooo.sopt28th.util.ToastMessageUtil

class SignUpActivity : BindingActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LifeCycle", "SignUp_onCreate")
        StatusBarUtil.setStatusBar(this, resources.getColor(R.color.main_color_purple, null))
        setOnSignUpBtnClick()
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

    private fun setOnSignUpBtnClick() {
        binding.signUpBtnSignUp.setOnClickListener {
            if (isUserInfoNotBlank()) {
                val intent = Intent()
                with(intent) {
                    putExtra("id", binding.signUpEdtId.text.toString())
                    putExtra("pw", binding.signUpEdtPw.text.toString())
                }
                setResult(Activity.RESULT_OK, intent)
                finish()
            } else {
                ToastMessageUtil(this, "이름, 아이디, 비밀번호를 모두 입력해주세요.")
            }
        }
    }

    private fun isUserInfoNotBlank(): Boolean {
        with(binding) {
            return signUpEdtName.text.isNotBlank() && signUpEdtId.text.isNotBlank() && signUpEdtPw.text.isNotBlank()
        }
    }
}