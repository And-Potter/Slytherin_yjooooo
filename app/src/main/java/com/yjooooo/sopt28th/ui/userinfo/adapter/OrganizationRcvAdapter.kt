package com.yjooooo.sopt28th.ui.userinfo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yjooooo.sopt28th.R
import com.yjooooo.sopt28th.databinding.ItemRcvOrganizationBinding
import com.yjooooo.sopt28th.ui.userinfo.model.ResponseOrganization

class OrganizationRcvAdapter :
    ListAdapter<ResponseOrganization, OrganizationRcvAdapter.OrganizationRcvViewHolder>(
        OrganizationRcvDiffUtil()
    ) {

    inner class OrganizationRcvViewHolder(private val binding: ItemRcvOrganizationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(organizationData: ResponseOrganization) {
            binding.organizationData = organizationData
            setImageRadius(binding)
        }
    }

    override fun onBindViewHolder(
        holder: OrganizationRcvViewHolder,
        position: Int
    ) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): OrganizationRcvViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemRcvOrganizationBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_rcv_organization, parent, false)
        return OrganizationRcvViewHolder(binding)
    }

    private class OrganizationRcvDiffUtil : DiffUtil.ItemCallback<ResponseOrganization>() {
        override fun areContentsTheSame(
            oldItem: ResponseOrganization,
            newItem: ResponseOrganization
        ): Boolean =
            oldItem == newItem

        override fun areItemsTheSame(
            oldItem: ResponseOrganization,
            newItem: ResponseOrganization
        ): Boolean =
            oldItem.login == newItem.login
    }

    private fun setImageRadius(binding: ItemRcvOrganizationBinding) {
        with(binding.rcvOrganizationImg) {
            setBackgroundResource(R.drawable.bg_img_radius)
            clipToOutline = true
        }
    }
}