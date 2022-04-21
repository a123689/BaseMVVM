package com.base.mvvm.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.base.mvvm.R
import com.base.mvvm.base.BaseFragment


class HomeFragment : BaseFragment(R.layout.fragment_home) {
    override fun init(view: View) {

    }

    override fun subscribeObserver(view: View) {
        viewModel.dataState.observe(viewLifecycleOwner){
            Log.d("TAGP",it.toString())
        }
    }

}