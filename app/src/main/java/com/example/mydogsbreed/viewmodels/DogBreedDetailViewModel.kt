package com.example.mydogsbreed.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.mydogsbreed.model.BreedImageObject
import com.example.mydogsbreed.network.DogBreedsApi
import com.example.mydogsbreed.network.RemoteDogBreedRepository

class DogBreedDetailViewModel(breedName: String, remoteRepo: RemoteDogBreedRepository) : ViewModel() {

val imageUrl:LiveData<BreedImageObject> = liveData {
    val imageObject = remoteRepo.getDogBreedImageUrl(breedName)
    emit(imageObject)
}


    /**
     * A creator is used to inject the breed name and repository instance into the [DogBreedDetailViewModel]
     */
    class DogBreedViewModelFactory(breedName: String) : ViewModelProvider.NewInstanceFactory() {
        private val dogBreedName: String
        private val dogDataRepository = DogBreedsApi()
        init {
            dogBreedName = breedName
        }
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return DogBreedDetailViewModel(dogBreedName, dogDataRepository) as T
        }
    }
}