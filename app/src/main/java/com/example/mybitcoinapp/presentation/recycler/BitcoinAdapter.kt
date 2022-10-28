package com.example.mybitcoinapp.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.domain.domain.models.Bitcoin
import com.example.mybitcoinapp.databinding.ItemBinding

class BitcoinAdapter(private val onItemClickListener: OnItemClickListener?): ListAdapter<com.example.domain.domain.models.Bitcoin, BitcoinViewHolder>(
    BitcoinDiff()
) {

    interface OnItemClickListener {
        fun onItemPicked(item: Bitcoin)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BitcoinViewHolder {
        val itemBinding = ItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return BitcoinViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BitcoinViewHolder, position: Int) =
        holder.bind(getItem(position), onItemClickListener)

}