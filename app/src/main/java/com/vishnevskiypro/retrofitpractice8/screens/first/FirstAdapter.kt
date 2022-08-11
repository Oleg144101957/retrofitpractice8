package com.vishnevskiypro.retrofitpractice8.screens.first

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.vishnevskiypro.retrofitpractice8.databinding.MoneyItemBinding
import com.vishnevskiypro.retrofitpractice8.models.nal.NalichkaItem

class FirstAdapter : RecyclerView.Adapter<FirstAdapter.FistViewHolder>() {

    inner class FistViewHolder (val binding: MoneyItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallBack = object : DiffUtil.ItemCallback<NalichkaItem>(){

        override fun areItemsTheSame(oldItem: NalichkaItem, newItem: NalichkaItem): Boolean {
            return oldItem.ccy == newItem.ccy
        }

        override fun areContentsTheSame(oldItem: NalichkaItem, newItem: NalichkaItem): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallBack)
        var listNal: List<NalichkaItem>
            get() = differ.currentList
            set(value){ differ.submitList(value) }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FistViewHolder {
        return FistViewHolder(MoneyItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: FistViewHolder, position: Int) {
        holder.binding.apply {
            val nalItem = listNal[position]
            itemName.text = nalItem.ccy
            itemBuy.text = nalItem.buy
            itemSale.text = nalItem.sale
        }
    }

    override fun getItemCount() = listNal.size
}