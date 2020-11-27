package com.example.mydogsbreed

import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import java.util.concurrent.TimeoutException

/**
 * Returns the value of a livedata post change or waits for it to have one, with a timeout of 2 seconds.
 */
@Throws(TimeoutException::class)
fun <T> LiveData<T>.getTestValue(): T {
    var data: T? = null
    val latch = CountDownLatch(1)
    val observer = object: Observer<T> {
        override fun onChanged(t: T?) {
            data = t
            latch.countDown()
            this@getTestValue.removeObserver(this)
        }
    }
    this.observeForever(observer)
    // to not wait indefinitely we remove observer after 2 seconds and return error
    if(!latch.await(2, TimeUnit.SECONDS)) {
        this.removeObserver(observer)
        throw TimeoutException("Livedata value not received")
    }
    return data as T
}