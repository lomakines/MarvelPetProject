package com.bignerdranch.android.marvelpetproject.domain.entity

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MarvelData(
    @SerializedName("bio")
    val bio: String,
    @SerializedName("createdby")
    val createdBy: String,
    @SerializedName("firstappearance")
    val firstAppearance: String,
    @SerializedName("imageurl")
    val imageUrl: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("realname")
    val realName: String,
    @SerializedName("team")
    val team: String,
) : Serializable