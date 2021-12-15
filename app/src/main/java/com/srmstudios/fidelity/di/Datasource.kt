package com.srmstudios.fidelity.di

import android.content.Context
import androidx.room.Room
import com.srmstudios.fidelity.data.database.JikanDatabase
import com.srmstudios.fidelity.data.network.IJikan
import com.srmstudios.fidelity.util.Util
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Datasource {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()

        return Retrofit.Builder()
            .baseUrl(Util.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Provides
    @Singleton
    fun provideIJikan(retrofit: Retrofit) = retrofit.create(IJikan::class.java)

    @Provides
    @Singleton
    fun provideJikanDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            JikanDatabase::class.java,
            Util.DATABASE_NAME
        ).build()
}