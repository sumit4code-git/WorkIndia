package com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.di

import android.content.Context
import androidx.room.Room
import com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.api.ExperimentAPI
import com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.local.dao.ExperimentDao
import com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.local.db.AppDatabase
import com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.remote.ExperimentRepo
import com.penpencil.physicswallah.feature.batchlanding.ui.Testing.Workindia.remote.ExperimentRepoImpl
import com.pw.pwdailylearning.network.ApiWorker
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class ExperimentModule {
    @Singleton
    @Provides
    fun provideOkHttpClient() = if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else {
        OkHttpClient
            .Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return Retrofit.Builder()
            .addConverterFactory(ApiWorker.gsonConverter)
            .client(ApiWorker.client)
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ExperimentAPI =
        retrofit.create(ExperimentAPI::class.java)

    @Binds
    @Singleton
    abstract fun bindExperimentDataSource(
        experimentRepoImpl: ExperimentRepoImpl
    ): ExperimentRepo

}

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "experiment_db"
        ).build()
    }

    @Provides
    fun provideExperimentDao(database: AppDatabase): ExperimentDao {
        return database.experimentDao()
    }
}



