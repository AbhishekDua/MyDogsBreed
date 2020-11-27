package com.example.mydogsbreed

import android.widget.ImageView
import com.example.mydogsbreed.ui.ImageLoader
import com.example.mydogsbreed.viewmodels.DogBreedDetailViewModel
import com.example.mydogsbreed.viewmodels.DogsBreedListViewModel
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Unit test for [ImageLoader]
 */
class ImageLoaderTest {

    private lateinit var imageLoader: ImageLoader

    @Before
    fun init() {
        imageLoader = FakeImageLoader()
    }

    @Test
    fun image_loader_isCorrect() {
        var isWorking = false
        imageLoader.loadImage("https://test.com", ImageView(null,null)) {
            isWorking = true
        }
        Assert.assertTrue(isWorking)
    }
}