package com.example.mydogsbreed.ui

import android.widget.ImageView

/**
 * Interface abstracting the library to be used for adding image to imageview
 */
interface ImageLoader {
    /**
     * function to load the image into imageview based on url
     * @param url [String] url to fetch image from
     * @param imageView [ImageView] to load the image into
     * @param fallbackAction [Function] to handle failure scenario
     */
    fun loadImage(url: String, imageView: ImageView, fallbackAction: (() -> Unit)? = null)
}