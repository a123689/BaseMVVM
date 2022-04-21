package com.base.mvvm.ui

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.base.mvvm.model.Blog
import com.base.mvvm.util.DataState
import com.base.mvvm.repository.MainRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@ExperimentalCoroutinesApi
class MainViewModel
@ViewModelInject
constructor(
    private val mainRepository: MainRepository
): ViewModel() {

    private val _dataState: MutableLiveData<List<Blog>> = MutableLiveData()

    val dataState: LiveData<List<Blog>>
        get() = _dataState

    fun getAllBlog(onComplete: (blogs: List<Blog>) -> Unit){
        viewModelScope.launch {
            mainRepository.getBlogs().collect{
                withContext(Dispatchers.Main) {
                    if (it is DataState.Success)
                        it.data.let { it1 -> onComplete(it1) }
                }
            }
        }
    }

    fun getAllBlog2(){
        viewModelScope.launch {
            mainRepository.getBlogs().collect{ result->
                withContext(Dispatchers.Main) {
                    if (result is DataState.Success)
                        result.data.let {
                            _dataState.value = it
                        }
                }
            }
        }
    }

}



















