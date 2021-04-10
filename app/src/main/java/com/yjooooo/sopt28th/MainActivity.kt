package com.yjooooo.sopt28th

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.databinding.DataBindingUtil
import com.yjooooo.sopt28th.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setOnLoginBtnClick()
    }

    private fun setOnLoginBtnClick() {
        mainBinding.btnLogin.setOnClickListener {
            val id = mainBinding.edtId.text
            val pw = mainBinding.edtPw.text
            if (id.isNullOrBlank() || pw.isNullOrBlank()) {
                Toast.makeText(this, "아이디와 비밀번호를 입력해주세요.", LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "$id 님 안녕하세요.", LENGTH_SHORT).show()
                val intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)
            }
        }
    }
}