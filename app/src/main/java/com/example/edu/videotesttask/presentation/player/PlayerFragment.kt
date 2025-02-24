package com.example.edu.videotesttask.presentation.player

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.edu.videotesttask.R
import com.example.edu.videotesttask.databinding.FragmentPlayerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PlayerFragment : Fragment() {
    private var _binding:FragmentPlayerBinding? = null
    private val binding get() = _binding!!

    private val args:PlayerFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPlayerBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.test.text = args.URL
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}