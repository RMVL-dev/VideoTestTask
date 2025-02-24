package com.example.edu.videotesttask

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.bumptech.glide.load.Options
import com.bumptech.glide.load.ResourceDecoder
import com.bumptech.glide.load.engine.Resource
import com.bumptech.glide.load.resource.SimpleResource
import android.media.MediaMetadataRetriever
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import java.io.File
import java.io.InputStream

class VideoFrameDecoder(private val bitmapPool: BitmapPool,private val context: Context) :
    ResourceDecoder<InputStream, Bitmap> {

    override fun handles(source: InputStream, options: Options) = true

    override fun decode(
        source: InputStream,
        width: Int,
        height: Int,
        options: Options
    ): Resource<Bitmap> {
        val retriever = MediaMetadataRetriever()
        try {
            val file = File.createTempFile("prefix", ".tmp")
            source.use { input ->
                file.outputStream().use { output ->
                    input.copyTo(output)
                }
            }
            retriever.setDataSource(file.absolutePath)
            val frame = retriever.getFrameAtTime(0) ?: BitmapFactory.decodeResource(context.resources, R.drawable.ic_fail)
            return SimpleResource(frame)
        } finally {
            retriever.release()
        }
    }
}