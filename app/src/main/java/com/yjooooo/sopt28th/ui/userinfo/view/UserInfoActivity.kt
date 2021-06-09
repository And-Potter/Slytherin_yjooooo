package com.yjooooo.sopt28th.ui.userinfo.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.yjooooo.sopt28th.R
import com.yjooooo.sopt28th.databinding.ActivityUserInfoBinding
import com.yjooooo.sopt28th.ui.base.BindingActivity
import com.yjooooo.sopt28th.ui.signin.view.SignInActivity
import com.yjooooo.sopt28th.ui.userinfo.viewmodel.UserInfoViewModel
import com.yjooooo.sopt28th.util.StatusBarUtil

class UserInfoActivity : BindingActivity<ActivityUserInfoBinding>(R.layout.activity_user_info) {
    private val userInfoViewModel: UserInfoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.setStatusBar(this, resources.getColor(R.color.white, null))
        setFollowingFragmentToWhole()
        setIsLogoutObserve()
    }

    private fun setFollowingFragmentToWhole() {
        val userFragment = UserFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.user_info_fragment_container, userFragment)
        transaction.commit()
    }

    private fun setIsLogoutObserve() {
        userInfoViewModel.isLogout.observe(this) { isLogout ->
            if (isLogout) {
                val intent = Intent(this, SignInActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                startActivity(intent)
                Toast.makeText(this, "로그아웃되었습니다.", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }
}