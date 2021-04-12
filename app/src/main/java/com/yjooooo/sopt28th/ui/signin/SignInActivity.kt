package com.yjooooo.sopt28th.ui.signin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.yjooooo.sopt28th.R
import com.yjooooo.sopt28th.databinding.ActivitySignInBinding
import com.yjooooo.sopt28th.ui.base.BindingActivity
import com.yjooooo.sopt28th.ui.home.HomeActivity
import com.yjooooo.sopt28th.ui.signup.SignUpActivity
import com.yjooooo.sopt28th.util.StatusBarUtil
import com.yjooooo.sopt28th.util.isEverythingNotBlank

class SignInActivity : BindingActivity<ActivitySignInBinding>(R.layout.activity_sign_in) {
    private val signUpActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        setIdPwAfterSignUp(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LifeCycle", "SignIn_onCreate")
        StatusBarUtil.setStatusBar(this,resources.getColor(R.color.main_color_purple, null))
        setOnLoginBtnClick()
        setOnSignUpBtnClick()
    }

    override fun onStart() {
        super.onStart()
        Log.d("LifeCycle", "SignIn_onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifeCycle", "SignIn_onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifeCycle", "SignIn_onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycle", "SignIn_onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycle", "SignIn_onDestroy")
    }

    private fun setOnLoginBtnClick() {
        binding.signInBtnLogin.setOnClickListener {
            val id = binding.signInEdtId.text
            val pw = binding.signInEdtPw.text
            if (isEverythingNotBlank(listOf(id, pw))) {
                Toast.makeText(this, "$id 님 안녕하세요. 로그인되셨습니다.", LENGTH_SHORT).show()
                startActivity(Intent(this, HomeActivity::class.java))
            } else {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요!", LENGTH_SHORT).show()
            }
        }
    }

    private fun setOnSignUpBtnClick() {
        binding.signInBtnSignUp.setOnClickListener {
            signUpActivityLauncher.launch(Intent(this, SignUpActivity::class.java))
        }
    }

    private fun setIdPwAfterSignUp(activityResult: ActivityResult) {
        if (activityResult.resultCode == RESULT_OK) {
            with(binding) {
                signInEdtId.setText(activityResult.data!!.getStringExtra("id"))
                signInEdtPw.setText(activityResult.data!!.getStringExtra("pw"))
            }
        }
    }
}