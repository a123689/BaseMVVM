package com.base.mvvm.base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.base.mvvm.ui.SplashFragment
import com.base.mvvm.util.PrefUtil
import com.bumptech.glide.RequestManager
import javax.inject.Inject

class MainFragmentFactory
@Inject
constructor(
    private val glide: RequestManager,
    private val prefUtil: PrefUtil
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {

        return when (className) {
            SplashFragment::class.java.name -> {
                SplashFragment()
            }
            else -> super.instantiate(classLoader, className)
        }

    }
}
