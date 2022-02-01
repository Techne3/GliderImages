package com.example.gliderimages.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gliderimages.databinding.FragmentPhotosBinding
import com.example.gliderimages.network.ApiManager
import com.example.gliderimages.repository.PhotoRepository
import com.example.gliderimages.view.adapter.PhotoAdapter
import com.example.gliderimages.viewModel.PhotoViewModel

class PhotoFragment : Fragment() {

    private var _binding: FragmentPhotosBinding? = null
    private val binding: FragmentPhotosBinding get() = _binding!!

    private val viewModel: PhotoViewModel by activityViewModels {
        PhotoViewModel.Factory(PhotoRepository(ApiManager()))
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPhotosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            viewModel.photos.observe(viewLifecycleOwner) { user ->
                jsonRv.apply {
                    adapter = user?.let { PhotoAdapter(it) }
                    layoutManager =
                        LinearLayoutManager(requireContext())
                }
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}