package com.example.appthemoviedb.presenter.moviesnowplaying

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appthemoviedb.R
import com.example.appthemoviedb.databinding.ItemMovieBinding
import com.example.appthemoviedb.domain.model.Movie
import com.example.appthemoviedb.presenter.util.onMovieItemClick

class NowPlayingMoviesViewHolder(
    itemMovieBinding: ItemMovieBinding,
    private val onItemClick: onMovieItemClick
) : RecyclerView.ViewHolder(itemMovieBinding.root) {

    private val movieTitle = itemMovieBinding.titleMovie
    private val moviePoster = itemMovieBinding.posterPathMovie

    fun bind(movie: Movie) {
        movieTitle.text = movie.title
        Glide.with(itemView)
            .load(movie.getFullPosterPath())
            .fallback(R.drawable.ic_img_loading_error)
            .into(moviePoster)

        itemView.setOnClickListener {
            onItemClick.invoke(movie.id)
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            onItemClick: (movieId: Int) -> Unit
        ): NowPlayingMoviesViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val itemBiding = ItemMovieBinding.inflate(inflater, parent, false)
            return NowPlayingMoviesViewHolder(itemBiding, onItemClick)
        }
    }

}