package com.example.mydogsbreed

import com.example.mydogsbreed.model.BreedImageObject
import com.example.mydogsbreed.model.Breeds
import com.example.mydogsbreed.network.RemoteDogBreedRepository

class FakeRemoteRepository: RemoteDogBreedRepository {

    override suspend fun getDogBreeds(): Breeds {
        val message = hashMapOf<String, List<String>>(Pair("Test Dog", arrayListOf()))
        return Breeds(message,"success", 200)
    }

    override suspend fun getDogBreedImageUrl(breedName: String): BreedImageObject {
        return BreedImageObject(url = "https://test.com",status = "success",code =  200)
    }

}