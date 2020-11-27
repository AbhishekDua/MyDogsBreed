package com.example.mydogsbreed.viewmodels

import androidx.lifecycle.*
import com.example.mydogsbreed.model.Breeds
import com.example.mydogsbreed.network.DogBreedsApi
import com.example.mydogsbreed.network.RemoteDogBreedRepository

class DogsBreedListViewModel(remoteRepository: RemoteDogBreedRepository) : ViewModel() {

    val breeds: LiveData<Breeds> = liveData {
        val breeds = remoteRepository.getDogBreeds()
        emit(breeds)
    }

    /**
     * Creator to inject [RemoteDogBreedRepository] instance into the [DogsBreedListViewModel]
     */
    object DogsBreedListViewModelFactory: ViewModelProvider.Factory {
        private val dogBreedRepository = DogBreedsApi()

        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return DogsBreedListViewModel(dogBreedRepository) as T
        }
    }

}