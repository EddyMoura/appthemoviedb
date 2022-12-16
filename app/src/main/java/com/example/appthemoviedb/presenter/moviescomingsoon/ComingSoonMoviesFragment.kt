package com.example.appthemoviedb.presenter.moviescomingsoon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import com.example.appthemoviedb.databinding.FragmentComingSoonMoviesBinding
import com.example.appthemoviedb.presenter.moviesloadmore.MoviesLoadStateAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ComingSoonMoviesFragment : Fragment() {

    private var _binding: FragmentComingSoonMoviesBinding? = null
    private val binding: FragmentComingSoonMoviesBinding get() = _binding!!

    private val viewModel: ComingSoonMoviesViewModel by viewModels()

    private lateinit var moviesComingSoonMoviesAdapter: ComingSoonMoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentComingSoonMoviesBinding.inflate(
        inflater,
        container,
        false
    ).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComingSoonMoviesAdapter()
        observeInitialLoadState()

        lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.comingSoonMoviesPagingData().collect { pagingData ->
                    moviesComingSoonMoviesAdapter.submitData(pagingData)
                }
            }
        }
    }

    private fun initComingSoonMoviesAdapter() {
        moviesComingSoonMoviesAdapter = ComingSoonMoviesAdapter()
        with(binding.recyclerMoviesComingSoon) {
            scrollToPosition(0)
            setHasFixedSize(true)
            adapter = moviesComingSoonMoviesAdapter.withLoadStateFooter(
                footer = MoviesLoadStateAdapter { moviesComingSoonMoviesAdapter.retry() }
            )
        }
    }

    private fun observeInitialLoadState() {
        lifecycleScope.launch {
            moviesComingSoonMoviesAdapter.loadStateFlow.collectLatest { loadState ->
                binding.flipperMoviesComingSoon.displayedChild =
                    when (loadState.refresh) {
                        is LoadState.Loading -> {
                            setShimmerVisibility(true)
                            FLIPPER_CHILD_LOADING
                        }
                        is LoadState.NotLoading -> {
                            setShimmerVisibility(false)
                            FLIPPER_CHILD_SUCCESS
                        }
                        is LoadState.Error -> {
                            setShimmerVisibility(false)
                            binding.includeViewMoviesErrorState.buttonRetry.setOnClickListener {
                                moviesComingSoonMoviesAdapter.refresh()
                            }
                            FLIPPER_CHILD_ERROR
                        }
                    }
            }
        }
    }

    private fun setShimmerVisibility(visibility: Boolean) {
        binding.includeViewMoviesLoadingState.shimmerMovies.run {
            isVisible = visibility
            if (visibility) {
                startShimmer()
            } else stopShimmer()
        }
    }

    companion object {
        private const val FLIPPER_CHILD_LOADING = 0
        private const val FLIPPER_CHILD_SUCCESS = 1
        private const val FLIPPER_CHILD_ERROR = 2
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}