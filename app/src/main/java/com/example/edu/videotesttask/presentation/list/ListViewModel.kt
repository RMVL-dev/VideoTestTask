package com.example.edu.videotesttask.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.edu.videotesttask.data.VideoResponse
import com.example.edu.videotesttask.domain.Repository
import com.example.edu.videotesttask.network.ResponseState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private  val repository: Repository
):ViewModel() {

    private val _videos = MutableStateFlow<ResponseState<VideoResponse>>(ResponseState.None())
    val videos = _videos.asStateFlow()

    fun getVideos(){
        viewModelScope.launch(Dispatchers.IO) {
            _videos.update {
                ResponseState.Loading()
            }
            val videoResponse = repository.getVideos()
            if (videoResponse.isSuccessful ){
                _videos.update {
                    videoResponse.body()?.let {
                        ResponseState.Success(it)
                    } ?: run {
                        ResponseState.Error(videoResponse.message())
                    }
                }
            }
        }
    }

}