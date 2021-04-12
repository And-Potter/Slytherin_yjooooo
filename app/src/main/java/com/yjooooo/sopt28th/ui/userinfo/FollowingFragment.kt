package com.yjooooo.sopt28th.ui.userinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yjooooo.sopt28th.R
import com.yjooooo.sopt28th.databinding.FragmentFollowingBinding
import com.yjooooo.sopt28th.ui.base.BindingFragment

class FollowingFragment : BindingFragment<FragmentFollowingBinding>(R.layout.fragment_following) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }
}