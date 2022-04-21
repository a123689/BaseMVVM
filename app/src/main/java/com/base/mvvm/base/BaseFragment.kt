package com.base.mvvm.base

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.base.mvvm.ui.MainViewModel


private const val TAG = "BaseFragment"
abstract class BaseFragment(
    @LayoutRes layout: Int
) : Fragment(layout) {

    var navController: NavController? = null
    val viewModel: MainViewModel by activityViewModels()
    abstract fun init(view: View)

    abstract fun subscribeObserver(view: View)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        init(view)
        subscribeObserver(view)
    }


}