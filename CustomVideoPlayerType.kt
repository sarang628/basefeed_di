package com.sarang.torang.di.basefeed_di

import android.util.Log
import androidx.compose.runtime.LaunchedEffect
import com.sarang.torang.VideoPlayer
import com.sarang.torang.compose.feed.internal.components.type.VideoPlayerType

fun CustomVideoPlayerType(onClick : () -> Unit = {}): VideoPlayerType = {
    //VideoPlayerScreen(videoUrl = it, isPlaying = true, onClick = {}, onPlay = {})

    LaunchedEffect(it.isPlaying) {
        Log.d("__CustomVideoPlayerType", "isPlaying : ${it.isPlaying}")
    }

    VideoPlayer(videoUrl        = it.url,
                playWhenReady   = it.isPlaying,
                onClick         = onClick)
}