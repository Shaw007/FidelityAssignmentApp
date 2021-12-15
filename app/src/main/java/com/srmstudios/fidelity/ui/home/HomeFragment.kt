package com.srmstudios.fidelity.ui.home

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.srmstudios.fidelity.R
import com.srmstudios.fidelity.data.database.entity.toSeasons
import com.srmstudios.fidelity.databinding.FragmentHomeBinding
import com.srmstudios.fidelity.ui.view_model.JikanViewModel
import com.srmstudios.fidelity.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: JikanViewModel by activityViewModels()
    private val adapter = HomeAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        setupViews()
        setupListeners()
    }

    private fun setupViews() {
        binding.recyclerViewHome.adapter = adapter
    }

    private fun setupListeners() {
        viewModel.seasons.observe(viewLifecycleOwner) { result ->
            result.data?.let { seasons ->
                adapter.submitList(seasons.toSeasons())
            }

            binding.progressBar.isVisible =
                result is Resource.Loading && result.data.isNullOrEmpty()
            binding.txtErrorMessage.isVisible =
                result is Resource.Error && result.data.isNullOrEmpty()
            binding.txtErrorMessage.text = result.error?.localizedMessage
        }
    }
}










