package com.example.edu.videotesttask

import android.content.Context
import android.graphics.Bitmap
import com.bumptech.glide.Glide
import com.bumptech.glide.Registry
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import java.io.InputStream

@GlideModule
class VideoGlideModule: AppGlideModule() {

    override fun registerComponents(context: Context, glide: Glide, registry: Registry) {
        registry.append(
            Registry.BUCKET_BITMAP,
            InputStream::class.java,
            Bitmap::class.java,
            VideoFrameDecoder(glide.bitmapPool, context)
        )
    }

    override fun isManifestParsingEnabled() = false
}