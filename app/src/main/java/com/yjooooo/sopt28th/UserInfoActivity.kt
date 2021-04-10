package com.yjooooo.sopt28th

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.yjooooo.sopt28th.databinding.ActivityUserInfoBinding

class UserInfoActivity : AppCompatActivity() {
    private lateinit var userInfoBinding: ActivityUserInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userInfoBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_info)
        setFollowingFragmentToWhole()
    }

    private fun setFollowingFragmentToWhole() {
        val followingFragment = FollowingFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.user_info_fragment_container, followingFragment)
        transaction.commit()
    }
}