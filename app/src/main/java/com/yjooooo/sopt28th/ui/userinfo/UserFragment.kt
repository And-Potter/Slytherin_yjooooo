package com.yjooooo.sopt28th.ui.userinfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yjooooo.sopt28th.R
import com.yjooooo.sopt28th.databinding.FragmentUserBinding
import com.yjooooo.sopt28th.ui.base.BindingFragment

class UserFragment : BindingFragment<FragmentUserBinding>(R.layout.fragment_user) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)
        return binding.root
    }
}