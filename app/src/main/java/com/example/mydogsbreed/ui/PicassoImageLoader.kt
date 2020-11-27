package com.example.mydogsbreed.ui

import android.widget.ImageView
import com.example.mydogsbreed.R
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class PicassoImageLoader : ImageLoader {
    private val picasso = Picasso.get()

    override fun loadImage(url: String, imageView: ImageView, fallbackAction: (() -> Unit)?) {
        picasso.load(url).placeholder(R.drawable.rotate_animation).into(imageView, object : Callback {
            override fun onSuccess() {

            }
            override fun onError(e: Exception?) {
                fallbackAction?.invoke()
            }
        })
    }

}