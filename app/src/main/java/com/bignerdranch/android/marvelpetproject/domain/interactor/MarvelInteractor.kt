package com.bignerdranch.android.marvelpetproject.domain.interactor

import com.bignerdranch.android.marvelpetproject.domain.entity.MarvelData
import retrofit2.Response

interface MarvelInteractor {

    suspend fun getMarvelList(): Response<List<MarvelData>>
}