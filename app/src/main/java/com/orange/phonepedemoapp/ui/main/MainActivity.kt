package com.orange.phonepedemoapp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.orange.phonepedemoapp.databinding.ActivityMainBinding
import com.orange.phonepedemoapp.entity.Movies
import com.orange.phonepedemoapp.ui.adapter.MoviesAdapter
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        //data will be fetch from viewmodel -> init
        viewModel.data.observe(this, androidx.lifecycle.Observer {
            //add movies to recyclerview
            setUpList(it)
        })

    }

    private fun setUpList(movies: Movies) {
        var moviesAdapter = MoviesAdapter(item = movies, context = this)
        binding.movieList.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        binding.movieList.adapter = moviesAdapter
        moviesAdapter.notifyDataSetChanged()
    }
}