package com.yjooooo.sopt28th

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.yjooooo.sopt28th.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var signUpBinding: ActivitySignUpBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        signUpBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up)
        setOnSignUpBtnClick()
    }

    private fun setOnSignUpBtnClick() {
        signUpBinding.signUpBtnSignUp.setOnClickListener {
            val name = signUpBinding.signUpEdtName.text
            val id = signUpBinding.signUpEdtId.text
            val pw = signUpBinding.signUpEdtPw.text
            if (name.isNullOrBlank() || id.isNullOrBlank() || pw.isNullOrBlank()) {
                Toast.makeText(this, "이름, 아이디, 비밀번호를 모두 입력해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent()
                intent.putExtra("id", id.toString())
                intent.putExtra("pw", pw.toString())
                setResult(Activity.RESULT_OK, intent)
                finish()
            }
        }
    }
}