package com.example.appthemoviedb.presenter.moviesloadmore

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.example.appthemoviedb.databinding.ItemMoviesLoadMoreStateBinding

class MoviesLoadMoreStateViewHolder(
    itemBinding: ItemMoviesLoadMoreStateBinding,
    retry: () -> Unit
) : RecyclerView.ViewHolder(itemBinding.root) {

    private val binding = ItemMoviesLoadMoreStateBinding.bind(itemView)
    private val progressBarLoadingMore = binding.progressLoadingMore
    private val textTryAgainMessage = binding.textTryAgain.also {
        it.setOnClickListener {
            retry()
        }
    }

    fun bind(loadState: LoadState) {
        progressBarLoadingMore.isVisible = loadState is LoadState.Loading
        textTryAgainMessage.isVisible = loadState is LoadState.Error
    }

    companion object {
        fun create(parent: ViewGroup, retry: () -> Unit): MoviesLoadMoreStateViewHolder {
            val itemBinding =  ItemMoviesLoadMoreStateBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return MoviesLoadMoreStateViewHolder(itemBinding, retry)
        }
    }
}