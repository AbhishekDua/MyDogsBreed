package com.example.mydogsbreed.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mydogsbreed.R
import com.example.mydogsbreed.viewmodels.DogBreedDetailViewModel
import kotlinx.android.synthetic.main.layout_dog_breed_detail.*

class DogBreedDetailFragment : Fragment() {

    private lateinit var dogBreedDetailViewModel: DogBreedDetailViewModel
    private lateinit var dogImageView: ImageView
    private lateinit var dogBreedName: TextView
    private val imageLoader = PicassoImageLoader()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_dog_breed_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dogImageView = dog_image
        dogBreedName = dog_breed
        val dogBreedNameValue = requireArguments().getString("breedName", "")
        dogBreedDetailViewModel =
            ViewModelProvider(this, DogBreedDetailViewModel.DogBreedViewModelFactory(dogBreedNameValue)).get(
                DogBreedDetailViewModel::class.java
            )
        populateUI(dogBreedNameValue)
    }

    /**
     * Fill up the breed name and load the image based on the url from viewmodel
     * @param breedName String name for which is to be displayed
     */
    private fun populateUI(breedName: String) {
        if (breedName.isEmpty()) {
            dogBreedName.text = "Some error Occurred"
        } else {
            dogBreedName.text = breedName
        }
        dogBreedDetailViewModel.imageUrl.observe(viewLifecycleOwner, Observer {
            if (it.status.toLowerCase() == "success" && it.url.isNotBlank()) {
                imageLoader.loadImage(it.url, dogImageView) {
                    dogImageView.contentDescription = "Image available"
                }
            }
        })
    }

    companion object {
        /**
         * Provides instance of [DogBreedDetailFragment] with breedname added as arguments
         * @param breedName String Name to be added for details
         */
        fun newInstance(breedName: String): DogBreedDetailFragment {
            val bundle = bundleOf(Pair("breedName", breedName))
            val fragment = DogBreedDetailFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}