package com.yjooooo.sopt28th.ui.userinfo

import android.os.Bundle
import com.yjooooo.sopt28th.R
import com.yjooooo.sopt28th.databinding.ActivityUserInfoBinding
import com.yjooooo.sopt28th.ui.base.BindingActivity
import com.yjooooo.sopt28th.util.StatusBarUtil

class UserInfoActivity : BindingActivity<ActivityUserInfoBinding>(R.layout.activity_user_info) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.setStatusBar(this,resources.getColor(R.color.main_color_purple, null))
        setFollowingFragmentToWhole()
    }

    private fun setFollowingFragmentToWhole() {
        val followingFragment = FollowingFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.user_info_fragment_container, followingFragment)
        transaction.commit()
    }
}