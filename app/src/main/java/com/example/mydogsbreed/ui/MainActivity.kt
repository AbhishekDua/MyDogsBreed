package com.example.mydogsbreed.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mydogsbreed.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // adding fragment only on first creation
        if (savedInstanceState == null) {
            val fragment = DogsBreedListFragment()
            supportFragmentManager.beginTransaction().add(R.id.container_view, fragment, DogsBreedListFragmentTag)
                .commit()
        }
    }

    /**
     * Opens [DogBreedDetailFragment] for breed name selected
     * @param breedName String name of the breed selected
     */
    fun loadBreedSpecifFragment(breedName: String) {
        val fragment = DogBreedDetailFragment.newInstance(breedName)
        supportFragmentManager.beginTransaction().addToBackStack("breedDetail")
            .replace(R.id.container_view, fragment, null).commit()
    }
}