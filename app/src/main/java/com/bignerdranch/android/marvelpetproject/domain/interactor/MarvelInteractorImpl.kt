package com.bignerdranch.android.marvelpetproject.domain.interactor

import com.bignerdranch.android.marvelpetproject.domain.entity.MarvelData
import com.bignerdranch.android.marvelpetproject.domain.repository.MarvelRepository
import retrofit2.Response

class MarvelInteractorImpl(
    private val repository: MarvelRepository
) : MarvelInteractor {

    override suspend fun getMarvelList(): Response<List<MarvelData>> =
        repository.getMarvelList()
}