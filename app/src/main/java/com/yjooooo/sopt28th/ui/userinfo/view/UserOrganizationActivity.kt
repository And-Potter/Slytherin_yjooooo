package com.yjooooo.sopt28th.ui.userinfo.view

import android.os.Bundle
import androidx.activity.viewModels
import com.yjooooo.sopt28th.R
import com.yjooooo.sopt28th.databinding.ActivityUserOrganizationBinding
import com.yjooooo.sopt28th.ui.base.BindingActivity
import com.yjooooo.sopt28th.ui.userinfo.adapter.OrganizationRcvAdapter
import com.yjooooo.sopt28th.ui.userinfo.viewmodel.UserOrganizationViewModel
import com.yjooooo.sopt28th.util.StatusBarUtil

class UserOrganizationActivity :
    BindingActivity<ActivityUserOrganizationBinding>(R.layout.activity_user_organization) {
    private val userOrganizationViewModel: UserOrganizationViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        StatusBarUtil.setStatusBar(this, resources.getColor(R.color.white, null))
        binding.lifecycleOwner = this
        userOrganizationViewModel.getUserOrganization()
        setOrganizationRcvAdapter()
        setOrganizationListObserve()
    }

    private fun setOrganizationRcvAdapter() {
        binding.rcvOrganization.adapter = OrganizationRcvAdapter()
    }

    private fun setOrganizationListObserve() {
        userOrganizationViewModel.organizationList.observe(this) { organizationList ->
            with(binding.rcvOrganization.adapter as OrganizationRcvAdapter) {
                submitList(organizationList)
            }
        }
    }
}