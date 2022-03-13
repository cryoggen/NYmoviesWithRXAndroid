package com.example.nymovies.presentation.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.nymovies.R

import com.example.nymovies.app.appComponent
import com.example.nymovies.databinding.FragmentMoviesListBinding



class MoviesListFragment : Fragment() {
    val component by lazy { requireContext().applicationContext.appComponent }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentMoviesListBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_movies_list,
            container,
            false
        )

        // Set the lifecycleOwner so DataBinding can observe LiveData
        binding.lifecycleOwner = viewLifecycleOwner
        // Inflate the layout for this fragment

        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = component.moviesListAdapter

        return binding.root
    }


}