package com.bignerdranch.android.marvelpetproject.domain.repository

import com.bignerdranch.android.marvelpetproject.domain.entity.MarvelData
import retrofit2.Response

interface MarvelRepository {

    suspend fun getMarvelList(): Response<List<MarvelData>>
}