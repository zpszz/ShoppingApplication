package com.jpc.shoppingapplication.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.appbar.MaterialToolbar
import com.jpc.shoppingapplication.R
import com.jpc.shoppingapplication.databinding.FragmentCartBinding
import com.jpc.shoppingapplication.databinding.FragmentClothesBinding

class CartFragment: Fragment(){
    private lateinit var binding: FragmentCartBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val activity = activity as AppCompatActivity
        binding = FragmentCartBinding.inflate(inflater, container, false)
        //val view = inflater.inflate(R.layout.fragment_cart, container, false)
        val materialToolbar = binding.tlHead
        materialToolbar.title = "购物车"
        activity.setSupportActionBar(materialToolbar)
        return binding.root
    }
}