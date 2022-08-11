package com.vishnevskiypro.retrofitpractice8.screens.first

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.vishnevskiypro.retrofitpractice8.R
import com.vishnevskiypro.retrofitpractice8.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding
    private lateinit var adapter: FirstAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val mViewModel = ViewModelProvider(this).get(FirstViewModel::class.java)

        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        recyclerView = binding.rvFirst
        adapter = FirstAdapter()
        recyclerView.adapter = adapter
        mViewModel.getNalFromRepo()

        mViewModel.moneyListNal.observe(viewLifecycleOwner, { list ->
            list.body()?.let { adapter.listNal = it }
        })


        return binding.root
    }
}