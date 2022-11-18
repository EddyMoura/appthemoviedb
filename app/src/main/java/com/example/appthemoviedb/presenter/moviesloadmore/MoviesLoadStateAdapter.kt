package com.example.appthemoviedb.presenter.moviesloadmore

import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter

class MoviesLoadStateAdapter(
    private val retry: () -> Unit
) : LoadStateAdapter<MoviesLoadMoreStateViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ) = MoviesLoadMoreStateViewHolder.create(parent, retry)

    override fun onBindViewHolder(
        holder: MoviesLoadMoreStateViewHolder,
        loadState: LoadState
    ) = holder.bind(loadState)
}