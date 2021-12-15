package com.srmstudios.fidelity.ui.search

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.srmstudios.fidelity.R
import com.srmstudios.fidelity.data.network.model.toSeasons
import com.srmstudios.fidelity.databinding.FragmentSearchBinding
import com.srmstudios.fidelity.ui.home.HomeAdapter
import com.srmstudios.fidelity.ui.view_model.JikanViewModel
import com.srmstudios.fidelity.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment(R.layout.fragment_search) {
    private lateinit var binding: FragmentSearchBinding
    private val viewModel: JikanViewModel by activityViewModels()
    private val adapter = HomeAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchBinding.bind(view)

        setupViews()
        setupListeners()
    }

    private fun setupViews() {
        binding.recyclerViewSearch.adapter = adapter
    }

    private fun setupListeners() {
        binding.btnSearch.setOnClickListener {
            viewModel.search(binding.edtSearch.text?.toString())
        }

        viewModel.searchSeasons.observe(viewLifecycleOwner) { result ->
            result.data?.let { seasons ->
                adapter.submitList(seasons.toSeasons())
            }

            binding.progressBar.isVisible =
                result is Resource.Loading && result.data.isNullOrEmpty()
            binding.txtErrorMessage.isVisible =
                result is Resource.Error && result.data.isNullOrEmpty()
            binding.txtErrorMessage.text = result.error?.localizedMessage
            if (result is Resource.Error && result.data.isNullOrEmpty()) {
                // this check is needed when the API call throws an exception i.e timeout or network error
                // StateFlow doesn't trigger again if updated again with the same value
                viewModel.clearSearch()
            }
        }
    }
}










