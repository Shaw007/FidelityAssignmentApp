package com.srmstudios.fidelity.ui.view_model

import androidx.lifecycle.*
import com.srmstudios.fidelity.data.repo.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class JikanViewModel @Inject constructor(
    private val movieRepository: MovieRepository
) : ViewModel() {

    val seasons = movieRepository.getMovies().asLiveData()

    private var _searchQuery = MutableStateFlow("")

    val searchSeasons = _searchQuery.flatMapLatest { query ->
        movieRepository.searchMovies(query)
    }.asLiveData()

    fun search(query: String?) {
        if (!query.isNullOrEmpty()) {
            _searchQuery.value = query
        }
    }

    fun clearSearch() {
        _searchQuery.value = ""
    }
}