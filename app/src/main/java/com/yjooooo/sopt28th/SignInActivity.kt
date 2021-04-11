package com.yjooooo.sopt28th

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.yjooooo.sopt28th.databinding.ActivitySignInBinding

class SignInActivity : AppCompatActivity() {
    private lateinit var signInBinding: ActivitySignInBinding
    private val signUpActivityLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        setIdPwAfterSignUp(it)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LifeCycle", "SignIn_onCreate")
        signInBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in)
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
        signInBinding.signInBtnLogin.setOnClickListener {
            val id = signInBinding.signInEdtId.text
            val pw = signInBinding.signInEdtPw.text
            if (id.isNullOrBlank() || pw.isNullOrBlank()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요!", LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "$id 님 안녕하세요. 로그인되셨습니다.", LENGTH_SHORT).show()
                startActivity(Intent(this, HomeActivity::class.java))
            }
        }
    }

    private fun setOnSignUpBtnClick() {
        signInBinding.signInBtnSignUp.setOnClickListener {
            signUpActivityLauncher.launch(Intent(this, SignUpActivity::class.java))
        }
    }

    private fun setIdPwAfterSignUp(activityResult: ActivityResult) {
        if (activityResult.resultCode == RESULT_OK) {
            signInBinding.signInEdtId.setText(activityResult.data!!.getStringExtra("id"))
            signInBinding.signInEdtPw.setText(activityResult.data!!.getStringExtra("pw"))
        }
    }
}