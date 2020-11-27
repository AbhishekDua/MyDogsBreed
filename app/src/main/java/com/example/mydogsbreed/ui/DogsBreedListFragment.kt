package com.example.mydogsbreed.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.mydogsbreed.R
import com.example.mydogsbreed.viewmodels.DogsBreedListViewModel
import kotlinx.android.synthetic.main.dogs_breed_names_fragment.*


const val DogsBreedListFragmentTag = "DogsBreedListFragment"
class DogsBreedListFragment : Fragment(), BreedClickCallback {
    private val dogsBreedListViewModel: DogsBreedListViewModel by viewModels { DogsBreedListViewModel.DogsBreedListViewModelFactory}
    private lateinit var breedListRecyclerView: RecyclerView
    private lateinit var emptyResponse: TextView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dogs_breed_names_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        breedListRecyclerView = breed_list
        emptyResponse = response
        dogsBreedListViewModel.breeds.observe(viewLifecycleOwner, Observer {
            if (it.status.toLowerCase() == "success") {
                val listOfBreeds = it.message.keys.toList()
                breedListRecyclerView.isVisible = true
                breedListRecyclerView.adapter = BreedListAdapter(listOfBreeds, this)
                emptyResponse.isVisible = false
            } else {
                emptyResponse.text = it.status
                emptyResponse.isVisible = true
                breedListRecyclerView.isVisible = false
            }
        })
    }

    override fun onClick(breedName: String) {
        if(lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED)) {
            (requireActivity() as MainActivity).loadBreedSpecifFragment(breedName)
        }
    }

}