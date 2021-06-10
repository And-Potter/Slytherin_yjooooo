package com.yjooooo.sopt28th.ui.userinfo.view

import android.os.Bundle
import androidx.activity.viewModels
import com.google.android.material.tabs.TabLayout
import com.yjooooo.sopt28th.R
import com.yjooooo.sopt28th.databinding.ActivityUserFollowBinding
import com.yjooooo.sopt28th.ui.base.BindingActivity
import com.yjooooo.sopt28th.ui.userinfo.adapter.FollowRcvAdapter
import com.yjooooo.sopt28th.ui.userinfo.viewmodel.UserFollowViewModel
import com.yjooooo.sopt28th.util.StatusBarUtil

class UserFollowActivity :
    BindingActivity<ActivityUserFollowBinding>(R.layout.activity_user_follow) {
    private val userFollowViewModel: UserFollowViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.setStatusBar(this, resources.getColor(R.color.white, null))
        userFollowViewModel.getUserFollowing()
        setTabItem()
        setFollowRcvAdapter()
        setFollowListObserve()
        binding.lifecycleOwner = this
    }

    private fun setTabItem() {
        binding.tabFollow.apply {
            addTab(binding.tabFollow.newTab().setText("Following"))
            addTab(binding.tabFollow.newTab().setText("Follower"))
        }
        binding.tabFollow.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                when (tab.position) {
                    0 -> {
                        userFollowViewModel.getUserFollowing()
                    }
                    1 -> {
                        userFollowViewModel.getUserFollower()
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {
            }

            override fun onTabReselected(tab: TabLayout.Tab) {
            }
        })
    }

    private fun setFollowRcvAdapter() {
        binding.rcvFollow.adapter = FollowRcvAdapter()
    }

    private fun setFollowListObserve() {
        userFollowViewModel.followList.observe(this) { followerList ->
            with(binding.rcvFollow.adapter as FollowRcvAdapter) {
                submitList(followerList)
            }
        }
    }
}