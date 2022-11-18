package com.example.appthemoviedb.presenter.moviesnowplaying

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.appthemoviedb.databinding.FragmentNowPlayingMoviesBinding
import com.example.appthemoviedb.domain.model.Movie
import dagger.hilt.android.AndroidEntryPoint
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

        lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.nowPlayingMoviesPagingData().collect() { pagingData ->
                    moviesNowPlayingMoviesAdapter.submitData(pagingData)
                }
            }
        }
    }

    private fun initNowPlayingMoviesAdapter() {
        moviesNowPlayingMoviesAdapter = NowPlayingMoviesAdapter()
        with(binding.recyclerMoviesNowPlaying) {
            scrollToPosition(0)
            setHasFixedSize(true)
            adapter = moviesNowPlayingMoviesAdapter
        }
    }
}