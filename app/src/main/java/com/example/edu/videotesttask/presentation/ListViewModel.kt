package com.example.edu.videotesttask.presentation

import androidx.lifecycle.ViewModel
import com.example.edu.videotesttask.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private  val repository: Repository
):ViewModel() {

}