package com.example.appthemoviedb.presenter.moviescomingsoon

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.appthemoviedb.domain.model.Movie

class ComingSoonMoviesAdapter : ListAdapter<Movie, ComingSoonMoviesViewHolder>(differCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComingSoonMoviesViewHolder {
        return ComingSoonMoviesViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ComingSoonMoviesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    companion object {
        private val differCallback = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem == newItem
            }
        }
    }
}