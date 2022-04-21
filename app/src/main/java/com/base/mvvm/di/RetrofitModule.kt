package com.base.mvvm.di

import android.util.Log
import androidx.constraintlayout.widget.Constraints
import com.base.mvvm.retrofit.BlogRetrofit
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object RetrofitModule {


    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }



    @Singleton
    @Provides
    fun provideRetrofit(gson:  Gson): BlogRetrofit =
        Retrofit.Builder()
//            .baseUrl("http://45.32.103.137/api/v1/public/")
            .baseUrl("https://open-api.xyz/placeholder/")
            .client(okHttpClient())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(BlogRetrofit::class.java)

    private fun httpLoggingInterceptor(): HttpLoggingInterceptor? {
        val httpLoggingInterceptor = HttpLoggingInterceptor { message ->
            Log.d(
                Constraints.TAG,
                "log: http log: $message"
            )
        }
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return httpLoggingInterceptor
    }

    private fun okHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor())
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()
    }

}




















