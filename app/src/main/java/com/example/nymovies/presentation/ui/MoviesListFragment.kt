package com.example.nymovies.presentation.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.coroutineScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nymovies.R
import com.example.nymovies.app.appComponent
import com.example.nymovies.databinding.FragmentMoviesListBinding
import com.example.nymovies.presentation.viewmodel.MoviesListViewModel
import com.example.nymovies.presentation.viewmodel.MoviesListViewModelFactory
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject


class MoviesListFragment : Fragment() {
    @Inject
    lateinit var vmFactory: MoviesListViewModelFactory
    private lateinit var vm: MoviesListViewModel

    private val component by lazy { requireContext().applicationContext.appComponent }

    override fun onAttach(context: Context) {
        component.inject(this)
        super.onAttach(context)

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
        vm = ViewModelProvider(this, vmFactory)[MoviesListViewModel::class.java]

        binding.lifecycleOwner = viewLifecycleOwner

        val adapter = component.moviesListAdapter
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = adapter

        lifecycle.coroutineScope.launch {
            vm.getMovies().collect {
                adapter.movies = it
            }
        }

        return binding.root
    }


}