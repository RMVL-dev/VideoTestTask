package com.example.edu.videotesttask.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.edu.videotesttask.R
import com.example.edu.videotesttask.databinding.FragmentListVideosBinding
import com.example.edu.videotesttask.network.ResponseState
import com.example.edu.videotesttask.presentation.list.adapter.VideoListAdapter
import com.example.edu.videotesttask.utils.collectFlowWhenStarted
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListVideosFragment : Fragment() {

    private var _binding: FragmentListVideosBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<ListViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListVideosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getVideos()
        val adapter = VideoListAdapter(requireContext())
        val divider = DividerItemDecoration(requireContext(), LinearLayoutManager.VERTICAL)
        divider.setDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.divider)!!)
        binding.rvVideoList.adapter = adapter
        binding.rvVideoList.addItemDecoration(divider)

        collectFlowWhenStarted(viewModel.videos){ response ->
            when(response){
                is ResponseState.Error -> {}
                is ResponseState.Loading -> {}
                is ResponseState.None -> {}
                is ResponseState.Success -> {
                    adapter.items = response.data.items
                    adapter.notifyDataSetChanged()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}