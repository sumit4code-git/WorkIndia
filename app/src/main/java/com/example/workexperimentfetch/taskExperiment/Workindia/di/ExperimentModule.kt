package com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.di

import com.google.gson.GsonBuilder
import com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.api.ExperimentAPI
import com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.remote.ExperimentRepo
import com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.remote.ExperimentRepoImpl
import com.pw.pwdailylearning.network.ApiWorker
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class ExperimentModule {

    companion object {

        @Singleton
        @Provides
        fun provideRetrofit(): Retrofit {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build()
            return Retrofit.Builder()
                .baseUrl("https://catfact.ninja")
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .client(client)
                .build()
        }

        @Singleton
        @Provides
        fun provideApiService(retrofit: Retrofit): ExperimentAPI {
            return retrofit.create(ExperimentAPI::class.java)
        }

    }

    @Binds
    @Singleton
    abstract fun bindExperimentDataSource(
        experimentRepoImpl: ExperimentRepoImpl
    ): ExperimentRepo

}



