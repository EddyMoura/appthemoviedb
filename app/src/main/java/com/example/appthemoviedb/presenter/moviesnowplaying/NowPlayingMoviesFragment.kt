package com.example.appthemoviedb.presenter.moviesnowplaying

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.appthemoviedb.databinding.FragmentNowPlayingMoviesBinding
import com.example.appthemoviedb.domain.model.Movie
import dagger.hilt.android.AndroidEntryPoint

class NowPlayingMoviesFragment : Fragment() {

    private var _binding: FragmentNowPlayingMoviesBinding? = null
    private val binding: FragmentNowPlayingMoviesBinding get() = _binding!!

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

        @Suppress("MaxLineLength")
        moviesNowPlayingMoviesAdapter.submitList(
            listOf(
                Movie("https://image.tmdb.org/t/p/w500/sv1xJUazXeYqALzczSZ3O6nkH75.jpg", 0, "Black Panther: Wakanda Forever"),
                Movie("https://image.tmdb.org/t/p/w500/sv1xJUazXeYqALzczSZ3O6nkH75.jpg", 0, "Black Panther: Wakanda Forever"),
                Movie("https://image.tmdb.org/t/p/w500/sv1xJUazXeYqALzczSZ3O6nkH75.jpg", 0, "Black Panther: Wakanda Forever"),
                Movie("https://image.tmdb.org/t/p/w500/sv1xJUazXeYqALzczSZ3O6nkH75.jpg", 0, "Black Panther: Wakanda Forever"),
                Movie("https://image.tmdb.org/t/p/w500/sv1xJUazXeYqALzczSZ3O6nkH75.jpg", 0, "Black Panther: Wakanda Forever"),

            )
        )

    }

    private fun initNowPlayingMoviesAdapter() {
        moviesNowPlayingMoviesAdapter = NowPlayingMoviesAdapter()
        with(binding.recyclerMoviesNowPlaying) {
            setHasFixedSize(true)
            adapter = moviesNowPlayingMoviesAdapter
        }
    }

}