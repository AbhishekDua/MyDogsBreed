package com.example.mydogsbreed

import android.widget.ImageView
import com.example.mydogsbreed.ui.ImageLoader

class FakeImageLoader : ImageLoader {
    override fun loadImage(url: String, imageView: ImageView, fallbackAction: (() -> Unit)?) {
        if(url.isNotEmpty()) {
            fallbackAction?.invoke()
        }
    }
}