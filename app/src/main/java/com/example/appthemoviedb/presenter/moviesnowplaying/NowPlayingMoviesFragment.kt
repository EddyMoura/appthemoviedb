package com.example.appthemoviedb.presenter.moviesnowplaying

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
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.example.appthemoviedb.databinding.FragmentNowPlayingMoviesBinding
import com.example.appthemoviedb.presenter.moviedetails.DetailMoviesViewArg
import com.example.appthemoviedb.presenter.moviesloadmore.MoviesLoadStateAdapter
import com.example.appthemoviedb.presenter.viewpager.ViewPagerFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NowPlayingMoviesFragment : Fragment() {

    private var _binding: FragmentNowPlayingMoviesBinding? = null
    private val binding: FragmentNowPlayingMoviesBinding get() = _binding!!

    private val viewModel: NowPlayingMoviesViewModel by viewModels()

    private lateinit var moviesNowPlayingMoviesAdapter: NowPlayingMoviesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentNowPlayingMoviesBinding.inflate(
        inflater,
        container,
        false
    ).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initNowPlayingMoviesAdapter()
        observeInitialLoadState()

        lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.nowPlayingMoviesPagingData().collect { pagingData ->
                    moviesNowPlayingMoviesAdapter.submitData(pagingData)
                }
            }
        }
    }

    private fun initNowPlayingMoviesAdapter() {
        moviesNowPlayingMoviesAdapter = NowPlayingMoviesAdapter { movieId ->
            val directions = ViewPagerFragmentDirections
                .actionViewPagerFragmentToDetailMoviesFragment(DetailMoviesViewArg(movieId))

            findNavController().navigate(directions)
        }

        with(binding.recyclerMoviesNowPlaying) {
            scrollToPosition(0)
            setHasFixedSize(true)
            adapter = moviesNowPlayingMoviesAdapter.withLoadStateFooter(
                footer = MoviesLoadStateAdapter { moviesNowPlayingMoviesAdapter.retry() }
            )
        }
    }

    private fun observeInitialLoadState() {
        lifecycleScope.launch {
            moviesNowPlayingMoviesAdapter.loadStateFlow.collectLatest { loadState ->
                binding.flipperMoviesNowPlaying.displayedChild =
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
                                moviesNowPlayingMoviesAdapter.refresh()
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