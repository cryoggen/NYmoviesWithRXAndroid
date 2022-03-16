package com.example.nymovies.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.cryoggen.data.source.models.remote.MultiMedia
import com.cryoggen.domain.models.Movie
import com.example.nymovies.R
import com.example.nymovies.databinding.MovieItemBinding


class MoviesListAdapter() : RecyclerView.Adapter<MovieViewHolder>() {


    var movies: List<Movie> = emptyList()
        set(value) {
            field = value

            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val movieItemBinding: MovieItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            MovieViewHolder.LAYOUT,
            parent,
            false)
        return MovieViewHolder(movieItemBinding)
    }

    override fun getItemCount() = movies.size


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.movie = movies[position]
            it.title.text = movies[position].displayTitle
            it.description.text = movies[position].summaryShort
        }
    }

}

/**
 * ViewHolder for DevByte items. All work is done by data binding.
 */
class MovieViewHolder(val viewDataBinding: MovieItemBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.movie_item
    }
}