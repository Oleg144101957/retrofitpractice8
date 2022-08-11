package com.vishnevskiypro.retrofitpractice8.screens.second

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.vishnevskiypro.retrofitpractice8.R
import com.vishnevskiypro.retrofitpractice8.databinding.FragmentFirstBinding
import com.vishnevskiypro.retrofitpractice8.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: SecondAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        val mViewModel = ViewModelProvider(this).get(SecondViewModel::class.java)

        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        recyclerView = binding.rvSecond
        adapter = SecondAdapter()
        recyclerView.adapter = adapter
        mViewModel.getBeznalFromRepo()

        mViewModel.moneyListBeznal.observe(viewLifecycleOwner, { list ->
            list.body()?.let { adapter.listBeznal = it }

        })


        return binding.root
    }

}