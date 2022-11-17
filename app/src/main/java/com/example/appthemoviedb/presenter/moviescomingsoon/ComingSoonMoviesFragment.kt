package com.example.appthemoviedb.presenter.moviescomingsoon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.appthemoviedb.databinding.FragmentComingSoonMoviesBinding
import com.example.appthemoviedb.domain.model.Movie

class ComingSoonMoviesFragment : Fragment() {

    private var _binding: FragmentComingSoonMoviesBinding? = null
    private val binding: FragmentComingSoonMoviesBinding get() = _binding!!

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

        @Suppress("MaxLineLength")
        moviesComingSoonMoviesAdapter.submitList(
            listOf(
                Movie("https://image.tmdb.org/t/p/w500/sv1xJUazXeYqALzczSZ3O6nkH75.jpg", 0, "Black Panther: Wakanda Forever"),
                Movie("https://image.tmdb.org/t/p/w500/sv1xJUazXeYqALzczSZ3O6nkH75.jpg", 0, "Black Panther: Wakanda Forever"),
                Movie("https://image.tmdb.org/t/p/w500/sv1xJUazXeYqALzczSZ3O6nkH75.jpg", 0, "Black Panther: Wakanda Forever"),
                Movie("https://image.tmdb.org/t/p/w500/sv1xJUazXeYqALzczSZ3O6nkH75.jpg", 0, "Black Panther: Wakanda Forever"),
                Movie("https://image.tmdb.org/t/p/w500/sv1xJUazXeYqALzczSZ3O6nkH75.jpg", 0, "Black Panther: Wakanda Forever"),

                )
        )
    }

    private fun initComingSoonMoviesAdapter() {
        moviesComingSoonMoviesAdapter = ComingSoonMoviesAdapter()
        with(binding.recyclerMoviesComingSoon) {
            setHasFixedSize(true)
            adapter = moviesComingSoonMoviesAdapter
        }
    }

}