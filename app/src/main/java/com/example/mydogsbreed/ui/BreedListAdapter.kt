package com.example.mydogsbreed.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mydogsbreed.R

class BreedListAdapter(val breeds: List<String>,val breedClickCallback: BreedClickCallback) : RecyclerView.Adapter<BreedListAdapter.BreedListViewHolder>() {

    inner class BreedListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        init {
            itemView.setOnClickListener(this)
        }
        private var breedName = itemView.findViewById<TextView>(R.id.breed_name)
        override fun onClick(v: View?) {
            breedClickCallback.onClick(breedName = breedName.text.toString())
        }
        fun bind(name: String) {
            breedName.text = name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreedListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_breed_item, parent, false)
        return BreedListViewHolder(view)
    }

    override fun onBindViewHolder(holder: BreedListViewHolder, position: Int) {
        holder.bind(breeds.get(position))
    }

    override fun getItemCount(): Int {
        return breeds.size
    }
}