package com.example.appthemoviedb.presenter.moviescomingsoon

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appthemoviedb.R
import com.example.appthemoviedb.databinding.ItemMovieBinding
import com.example.appthemoviedb.domain.model.Movie

class ComingSoonMoviesViewHolder(
    itemMovieBinding: ItemMovieBinding
) : RecyclerView.ViewHolder(itemMovieBinding.root) {

    private val movieTitle = itemMovieBinding.titleMovie
    private val moviePoster = itemMovieBinding.posterPathMovie

    fun bind(movie: Movie) {
        movieTitle.text = movie.title
        Glide.with(itemView)
            .load(movie.getFullPosterPath())
            .fallback(R.drawable.ic_img_loading_error)
            .into(moviePoster)
    }

    companion object {
        fun create(parent: ViewGroup): ComingSoonMoviesViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val itemBinding = ItemMovieBinding.inflate(inflater, parent, false)
            return ComingSoonMoviesViewHolder(itemBinding)
        }
    }
}