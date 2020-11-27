package com.example.mydogsbreed.network

import com.example.mydogsbreed.model.BreedImageObject
import com.example.mydogsbreed.model.Breeds
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Retrofit services to get data from url
 */

/**
 * gets list of all breeds
 */
interface BreedListService {
    @GET("breeds/list/all")
    suspend fun getBreeds(): Breeds
}

/**
 * get url of image assciated to breed
 */
interface BreedImageService {
    @GET("breed/{breedName}/images/random")
    suspend fun getBreedImageUrl(@Path("breedName") breedName: String): BreedImageObject
}