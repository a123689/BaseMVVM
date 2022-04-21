package com.base.mvvm.ui

import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.base.mvvm.R
import com.base.mvvm.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashFragment : BaseFragment(R.layout.fragment_splash) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
    override fun init(view: View) {
        viewModel.getAllBlog2()
        CoroutineScope(Dispatchers.Default).launch {
            delay(7000)
            navController?.navigate(R.id.action_splashFragment_to_homeFragment)
        }
    }

    override fun subscribeObserver(view: View) {
//        viewModel.dataState.observe(viewLifecycleOwner){
//            Log.d("TAGP",it.toString())
//        }
    }

}