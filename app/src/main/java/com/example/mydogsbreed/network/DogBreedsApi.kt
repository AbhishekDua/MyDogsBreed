package com.example.mydogsbreed.network

import com.example.mydogsbreed.model.BreedImageObject
import com.example.mydogsbreed.model.Breeds
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Implementation of [RemoteDogBreedRepository] using retrofit library
 */
class DogBreedsApi : RemoteDogBreedRepository {

    val breedListService: BreedListService by lazy {  retrofit.create(BreedListService::class.java) }

    val breedImageService : BreedImageService by lazy {
        retrofit.create(BreedImageService::class.java)
    }

    override suspend fun getDogBreeds(): Breeds {
        return breedListService.getBreeds()
    }

    override suspend fun getDogBreedImageUrl(breedName: String): BreedImageObject {
        return breedImageService.getBreedImageUrl(breedName)
    }

    companion object {
        private const val BASE_URL = "https://dog.ceo/api/"

        private val gson = GsonBuilder().create()

        private val retrofit =
            Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson)).baseUrl(BASE_URL).build()

    }

}