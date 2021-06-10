package com.yjooooo.sopt28th.ui.userinfo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yjooooo.sopt28th.R
import com.yjooooo.sopt28th.databinding.ItemRcvFollowBinding
import com.yjooooo.sopt28th.ui.userinfo.model.ResponseFollow

class FollowRcvAdapter : ListAdapter<ResponseFollow, FollowRcvAdapter.FollowRcvViewHolder>(
    FollowRcvDiffUtil()
) {

    inner class FollowRcvViewHolder(private val binding: ItemRcvFollowBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(followData: ResponseFollow) {
            binding.followData = followData
        }
    }

    override fun onBindViewHolder(
        holder: FollowRcvViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FollowRcvViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemRcvFollowBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_rcv_follow, parent, false)
        return FollowRcvViewHolder(binding)
    }

    private class FollowRcvDiffUtil : DiffUtil.ItemCallback<ResponseFollow>() {
        override fun areContentsTheSame(
            oldItem: ResponseFollow,
            newItem: ResponseFollow
        ): Boolean =
            oldItem == newItem

        override fun areItemsTheSame(
            oldItem: ResponseFollow,
            newItem: ResponseFollow
        ): Boolean =
            oldItem.login == newItem.login
    }
}