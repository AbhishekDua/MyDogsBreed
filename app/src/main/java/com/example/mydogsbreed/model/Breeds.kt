package com.example.mydogsbreed.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class Breeds(
    @SerializedName("message")
    val message: Map<String, List<String>>,
    @SerializedName("status")
    val status: String,
    @SerializedName("code")
    val code: Int = 0
) : Serializable