package com.yjooooo.sopt28th.ui.signup

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.yjooooo.sopt28th.R
import com.yjooooo.sopt28th.databinding.ActivitySignUpBinding
import com.yjooooo.sopt28th.ui.base.BindingActivity
import com.yjooooo.sopt28th.util.StatusBarUtil
import com.yjooooo.sopt28th.util.isEverythingNotBlank

class SignUpActivity : BindingActivity<ActivitySignUpBinding>(R.layout.activity_sign_up) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LifeCycle", "SignUp_onCreate")
        StatusBarUtil.setStatusBar(this,resources.getColor(R.color.main_color_purple, null))
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
            val name = binding.signUpEdtName.text
            val id = binding.signUpEdtId.text
            val pw = binding.signUpEdtPw.text
            if (isEverythingNotBlank(listOf(name, id, pw))) {
                val intent = Intent()
                with(intent){
                    putExtra("id", id.toString())
                    putExtra("pw", pw.toString())
                }
                setResult(Activity.RESULT_OK, intent)
                finish()
            } else {
                Toast.makeText(this, "이름, 아이디, 비밀번호를 모두 입력해주세요.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}