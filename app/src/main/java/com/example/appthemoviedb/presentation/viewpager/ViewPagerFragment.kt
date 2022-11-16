package com.example.appthemoviedb.presentation.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appthemoviedb.R
import com.example.appthemoviedb.databinding.FragmentViewPagerBinding
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerFragment : Fragment() {

    private var _binding: FragmentViewPagerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentViewPagerBinding.inflate(inflater, container, false)
        showViewPager()
        return binding.root
    }

    private fun showViewPager() {
        val tabLayout = binding.fragmentViewPagerTabLayout
        val adapter = ViewPagerAdapter(
            requireActivity().supportFragmentManager,
            lifecycle
        )
        val viewPager = binding.fragmentViewPager
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getTabTitle(position)
        }.attach()
    }

    private fun getTabTitle(position: Int): String? {
        return when (position) {
            0 -> getString(R.string.now_playing_title)
            1 -> getString(R.string.coming_soon_title)
            else -> null
        }
    }

}