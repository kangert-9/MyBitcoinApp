package com.example.mybitcoinapp.presentation.recycler

import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mybitcoinapp.databinding.ItemBinding
import com.example.domain.domain.models.Bitcoin

class BitcoinViewHolder(private val viewBinding: ItemBinding): RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(item: Bitcoin, onItemClickListener: BitcoinAdapter.OnItemClickListener?) {
        viewBinding.itemName.text = item.name
        viewBinding.itemBtc.text = item.symbol
        viewBinding.itemBtc.isAllCaps = true
        viewBinding.itemCost.text = item.current_price.toString()
        viewBinding.itemPercent.text = item.ath_change_percentage.toString()+ " %"
        if (item.ath_change_percentage.toString().first().toString() =="-"){
            viewBinding.itemPercent.setTextColor(Color.RED)
        } else {
            viewBinding.itemPercent.setTextColor(Color.GREEN)
        }


        Glide.with(viewBinding.itemImage.context)
            .load(item.image)
            .into(viewBinding.itemImage)

        viewBinding.root.setOnClickListener {
            onItemClickListener?.onItemPicked(item)
        }
    }
}