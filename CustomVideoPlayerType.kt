package com.sarang.torang.di.basefeed_di

import com.sarang.torang.VideoPlayer
import com.sarang.torang.compose.feed.internal.components.type.VideoPlayerType

fun CustomVideoPlayerType(onClick   : () -> Unit = {},
                          onPlayed  : () -> Unit = {}): VideoPlayerType = {
    VideoPlayer(videoUrl        = it.url,
                playWhenReady   = it.isPlaying,
                onClick         = onClick,
                onPlayed        = onPlayed)
}