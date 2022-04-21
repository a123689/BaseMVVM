package com.base.mvvm.di

import com.base.mvvm.repository.MainRepository
import com.base.mvvm.retrofit.BlogRetrofit
import com.base.mvvm.retrofit.NetworkMapper
import com.base.mvvm.room.BlogDao
import com.base.mvvm.room.CacheMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideMainRepository(
        blogDao: BlogDao,
        retrofit: BlogRetrofit,
        cacheMapper: CacheMapper,
        networkMapper: NetworkMapper
    ): MainRepository{
        return MainRepository(blogDao, retrofit, cacheMapper, networkMapper)
    }
}














