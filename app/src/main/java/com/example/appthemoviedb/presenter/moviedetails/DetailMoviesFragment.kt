package com.example.appthemoviedb.presenter.moviedetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.appthemoviedb.R
import com.example.appthemoviedb.data.framework.imageloader.ImageLoader
import com.example.appthemoviedb.databinding.FragmentDetailMoviesBinding
import com.example.appthemoviedb.domain.model.MovieDetails
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@AndroidEntryPoint
class DetailMoviesFragment : Fragment() {

    private var _binding: FragmentDetailMoviesBinding? = null
    private val binding: FragmentDetailMoviesBinding get() = _binding!!

    private val viewModel: DetailMoviesViewModel by viewModels()

    private val args by navArgs<DetailMoviesFragmentArgs>()

    @Inject
    lateinit var imageLoader: ImageLoader

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentDetailMoviesBinding.inflate(
        inflater,
        container,
        false
    ).apply {
        _binding = this
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val detailViewArg = args.detailMoviesViewArg
        observerInitialLoadState()
        viewModel.getMovieDetails(detailViewArg.movieId)
    }

    private fun observerInitialLoadState() {
        viewModel.uiState.observe(viewLifecycleOwner) { uiState ->
            when (uiState) {
                DetailMoviesViewModel.UiState.Loading -> {
                }
                is DetailMoviesViewModel.UiState.Success -> {
                    setMoviesData(uiState.movieDetails)
                }
                DetailMoviesViewModel.UiState.Error -> {

                }
            }
        }
    }

    private fun setMoviesData(movie: MovieDetails) {
        binding.apply {
            imageLoader

            Glide.with(requireContext())
                .load(movie.getFullBackdropPath())
                .fallback(R.drawable.ic_img_loading_error)
                .into(detailItemImageBackdrop)

            detailItemTitle.text = movie.title
            detailItemVoteAverage.text = formatDouble(movie.voteAverage)
            detailItemRuntime.text = fromMinutesToHHmm(movie.runtime)
            detailItemOverview.text = movie.overview
            detailItemGenres.text = movie.genres.joinToString()
        }
    }

    @Suppress("ImplicitDefaultLocale")
    private fun fromMinutesToHHmm(minutes: Int): String {
        val hours = TimeUnit.MINUTES.toHours(minutes.toLong())
        val remainMinutes = minutes - TimeUnit.HOURS.toMinutes(hours)
        return String.format("%01dhr %02dm", hours, remainMinutes)
    }

    @Suppress("ImplicitDefaultLocale")
    private fun formatDouble(vote: Double): String {
        return String.format("%.1f", vote)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}