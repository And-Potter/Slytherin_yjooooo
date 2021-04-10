package com.yjooooo.sopt28th

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.yjooooo.sopt28th.databinding.FragmentFollowingBinding

class FollowingFragment : Fragment() {
    private var _followingBinding: FragmentFollowingBinding? = null
    private val followingBinding
        get() = _followingBinding ?: error("View를 참조하기 위해 binding이 초기화되지 않았습니다.")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _followingBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_following, container, false)
        return followingBinding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _followingBinding = null
    }
}