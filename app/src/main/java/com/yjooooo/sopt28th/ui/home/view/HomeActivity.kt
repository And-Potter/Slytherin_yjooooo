package com.yjooooo.sopt28th.ui.home.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.yjooooo.sopt28th.R
import com.yjooooo.sopt28th.databinding.ActivityHomeBinding
import com.yjooooo.sopt28th.ui.base.BindingActivity
import com.yjooooo.sopt28th.ui.home.adapter.RepoRcvAdapter
import com.yjooooo.sopt28th.ui.home.viewmodel.HomeViewModel
import com.yjooooo.sopt28th.ui.userinfo.view.UserInfoActivity
import com.yjooooo.sopt28th.util.StatusBarUtil

class HomeActivity : BindingActivity<ActivityHomeBinding>(R.layout.activity_home) {
    private val homeViewModel: HomeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.setStatusBar(this, resources.getColor(R.color.main_color_purple, null))
        Log.d("LifeCycle", "Home_onCreate")
        homeViewModel.addRepoList()
        setRepoRcvAdapter()
        setRepoListObserver()
        setOnUserInfoBtnClick()
    }

    override fun onStart() {
        super.onStart()
        Log.d("LifeCycle", "Home_onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifeCycle", "Home_onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifeCycle", "Home_onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifeCycle", "Home_onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifeCycle", "Home_onDestroy")
    }

    private fun setRepoRcvAdapter() {
        binding.homeRcvRepository.adapter = RepoRcvAdapter()
    }

    private fun setRepoListObserver() {
        homeViewModel.repoList.observe(this) { repoList ->
            repoList.let {
                if (binding.homeRcvRepository.adapter != null) with(binding.homeRcvRepository.adapter as RepoRcvAdapter) {
                    submitList(repoList)
                }
            }
        }
    }

    private fun setOnUserInfoBtnClick() {
        binding.homeBtnUserInfo.setOnClickListener {
            startActivity(Intent(this, UserInfoActivity::class.java))
        }
    }
}