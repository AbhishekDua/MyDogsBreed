package com.example.mydogsbreed.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BreedImageObject(
    @SerializedName("message")
    val url: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("code")
    val code: Int = 0
): Serializable