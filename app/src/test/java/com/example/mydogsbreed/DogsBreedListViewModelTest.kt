package com.example.mydogsbreed

import android.widget.ImageView
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.example.mydogsbreed.model.Breeds
import com.example.mydogsbreed.network.RemoteDogBreedRepository
import com.example.mydogsbreed.ui.ImageLoader
import com.example.mydogsbreed.viewmodels.DogBreedDetailViewModel
import com.example.mydogsbreed.viewmodels.DogsBreedListViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.MainCoroutineDispatcher
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.test.TestCoroutineDispatcher
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

/**
 * Unit test for [DogsBreedListViewModel]
 */
class DogsBreedListViewModelTest {

    private lateinit var dogsBreedListViewModel: DogsBreedListViewModel
    private lateinit var repo: RemoteDogBreedRepository

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()
    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutineTestRule = MainCoroutineRule()

    @Before
    fun init() {
        repo = FakeRemoteRepository()
        dogsBreedListViewModel = DogsBreedListViewModel(repo)
    }

    @Test
    fun breed_isCorrect() {
        val breeds = dogsBreedListViewModel.breeds.getTestValue()

        assertTrue(breeds.status == "success")
        assertTrue(breeds.message.containsKey("Test Dog"))
    }
}