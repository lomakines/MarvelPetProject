package com.bignerdranch.android.marvelpetproject.data.repository

import com.bignerdranch.android.marvelpetproject.data.network.RetrofitClient
import com.bignerdranch.android.marvelpetproject.domain.entity.MarvelData
import com.bignerdranch.android.marvelpetproject.domain.repository.MarvelRepository
import retrofit2.Response

class MarvelRepositoryImpl(
    private val apiInterface: RetrofitClient
) : MarvelRepository {

    override suspend fun getMarvelList():
            Response<List<MarvelData>> = apiInterface.create().getHeroes()
}