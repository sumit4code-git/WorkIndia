package  com.example.workexperimentfetch.taskExperiment.worksTasks.di

import com.example.workexperimentfetch.taskExperiment.worksTasks.api.ExperimentAPI
import com.example.workexperimentfetch.taskExperiment.worksTasks.remote.ExperimentRepo
import com.example.workexperimentfetch.taskExperiment.worksTasks.remote.ExperimentRepoImpl
import com.google.gson.GsonBuilder
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



