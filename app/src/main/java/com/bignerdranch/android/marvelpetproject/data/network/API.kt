package com.bignerdranch.android.marvelpetproject.data.network

import com.bignerdranch.android.marvelpetproject.domain.entity.MarvelData
import retrofit2.Response
import retrofit2.http.GET

interface API {

    @GET("marvel")
    suspend fun getHeroes(): Response<List<MarvelData>>
}