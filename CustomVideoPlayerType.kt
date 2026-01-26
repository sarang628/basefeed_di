package com.sarang.torang.di.basefeed_di

import com.sarang.torang.VideoPlayer
import com.sarang.torang.compose.feed.internal.components.type.VideoPlayerType

val CustomVideoPlayerType: VideoPlayerType = {
    //VideoPlayerScreen(videoUrl = it, isPlaying = true, onClick = {}, onPlay = {})
    VideoPlayer(videoUrl        = it.url,
                playWhenReady   = it.isPlaying)
}