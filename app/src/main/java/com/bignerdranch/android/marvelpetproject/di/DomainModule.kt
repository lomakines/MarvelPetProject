package com.bignerdranch.android.marvelpetproject.di

import com.bignerdranch.android.marvelpetproject.domain.interactor.MarvelInteractor
import com.bignerdranch.android.marvelpetproject.domain.interactor.MarvelInteractorImpl
import com.bignerdranch.android.marvelpetproject.domain.repository.MarvelRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideMarvelInteractor(repository: MarvelRepository): MarvelInteractor {
        return MarvelInteractorImpl(repository = repository)
    }
}