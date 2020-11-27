package com.example.mydogsbreed.network

import com.example.mydogsbreed.model.BreedImageObject
import com.example.mydogsbreed.model.Breeds

/**
 * Repository interface to get data from remote
 */
interface RemoteDogBreedRepository {
    suspend fun getDogBreeds(): Breeds
    suspend fun getDogBreedImageUrl(breedName: String): BreedImageObject
}