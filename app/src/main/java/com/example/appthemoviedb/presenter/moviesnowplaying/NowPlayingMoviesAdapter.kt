package com.example.appthemoviedb.presenter.moviesnowplaying

import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.appthemoviedb.domain.model.Movie
import com.example.appthemoviedb.presenter.util.onMovieItemClick

class NowPlayingMoviesAdapter(
    private val onItemClick: onMovieItemClick
) :
    PagingDataAdapter<Movie, NowPlayingMoviesViewHolder>(differCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowPlayingMoviesViewHolder {
        return NowPlayingMoviesViewHolder.create(parent, onItemClick)
    }

    override fun onBindViewHolder(holder: NowPlayingMoviesViewHolder, position: Int) {
        getItem(position)?.let {
            holder.bind(it)
        }
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