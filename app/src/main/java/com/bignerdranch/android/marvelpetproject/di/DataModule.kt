package com.bignerdranch.android.marvelpetproject.di

import com.bignerdranch.android.marvelpetproject.data.network.RetrofitClient
import com.bignerdranch.android.marvelpetproject.data.repository.MarvelRepositoryImpl
import com.bignerdranch.android.marvelpetproject.domain.repository.MarvelRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideMarvelRepository(): MarvelRepository {
        return MarvelRepositoryImpl(apiInterface = RetrofitClient)
    }

    @Provides
    @Singleton
    fun provideNetwork(): RetrofitClient {
        return RetrofitClient
    }
}