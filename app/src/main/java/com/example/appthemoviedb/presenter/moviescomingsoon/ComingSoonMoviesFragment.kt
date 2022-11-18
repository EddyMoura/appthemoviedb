package com.example.appthemoviedb.presenter.moviescomingsoon

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.appthemoviedb.databinding.FragmentComingSoonMoviesBinding
import dagger.hilt.android.AndroidEntryPoint
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
            adapter = moviesComingSoonMoviesAdapter
        }
    }

}