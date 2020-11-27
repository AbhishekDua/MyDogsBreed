package com.example.mydogsbreed

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.mydogsbreed.network.RemoteDogBreedRepository
import com.example.mydogsbreed.viewmodels.DogBreedDetailViewModel
import com.example.mydogsbreed.viewmodels.DogsBreedListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Unit test for [DogBreedDetailViewModel]
 */
class DogBreedDetailViewModelTest {

    private lateinit var repo: RemoteDogBreedRepository
    private lateinit var dogsDetailViewModel: DogBreedDetailViewModel

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()
    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutineTestRule = MainCoroutineRule()

    @Before
    fun init() {
        repo = FakeRemoteRepository()
        dogsDetailViewModel = DogBreedDetailViewModel("test", repo)
    }

    @Test
    fun breedUrl_isCorrect() {
        val breedImageObj = dogsDetailViewModel.imageUrl.getTestValue()
        Assert.assertTrue(breedImageObj.status == "success")
        Assert.assertEquals(breedImageObj.url, "https://test.com")
    }
}