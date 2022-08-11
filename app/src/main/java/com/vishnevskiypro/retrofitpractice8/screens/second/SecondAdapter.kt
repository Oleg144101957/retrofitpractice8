package com.vishnevskiypro.retrofitpractice8.screens.second

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.vishnevskiypro.retrofitpractice8.databinding.MoneyItemBinding
import com.vishnevskiypro.retrofitpractice8.models.beznal.BeznalItem

class SecondAdapter : RecyclerView.Adapter<SecondAdapter.SecondViewHolder>(){
    inner class SecondViewHolder (val binding: MoneyItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallBack = object : DiffUtil.ItemCallback<BeznalItem>(){

        override fun areItemsTheSame(oldItem: BeznalItem, newItem: BeznalItem): Boolean {
            return oldItem.ccy == newItem.ccy
        }

        override fun areContentsTheSame(oldItem: BeznalItem, newItem: BeznalItem): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallBack)
        var listBeznal: List<BeznalItem>
            get() = differ.currentList
            set(value){ differ.submitList(value) }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SecondViewHolder {
        return SecondViewHolder(MoneyItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
            ))
    }


    override fun onBindViewHolder(holder: SecondViewHolder, position: Int) {
        holder.binding.apply {
            val beznalItem = listBeznal[position]
            itemName.text = beznalItem.ccy
            itemBuy.text = beznalItem.buy
            itemSale.text = beznalItem.sale
        }
    }

    override fun getItemCount() = listBeznal.size
}