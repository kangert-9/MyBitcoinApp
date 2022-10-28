package com.example.mybitcoinapp.presentation.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.domain.models.Bitcoin

class BitcoinDiff : DiffUtil.ItemCallback<Bitcoin>() {

    override fun areItemsTheSame(oldItem: Bitcoin, newItem: Bitcoin): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Bitcoin, newItem: Bitcoin): Boolean {
        return oldItem == newItem
    }
}