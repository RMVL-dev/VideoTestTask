package com.example.edu.videotesttask.presentation.list.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.edu.videotesttask.data.VideoItem
import com.example.edu.videotesttask.databinding.ItemVideoBinding

class VideoListAdapter(
    private val context: Context
):RecyclerView.Adapter<VideoViewHolder>() {

    var items:List<VideoItem> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder =
        VideoViewHolder(
            ItemVideoBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            ),
            context = context
        )


    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(item = items[position])
    }
}