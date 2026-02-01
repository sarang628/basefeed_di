package com.sarang.torang.di.basefeed_di

import TorangAsyncImage
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import com.sarang.torang.LocalThumbImageLoader
import com.sarang.torang.ShortItem
import com.sarang.torang.ShortVideo
import com.sarang.torang.VideoPlayer
import com.sarang.torang.compose.feed.internal.components.type.VideoPlayerType

fun CustomVideoPlayerType(onClick   : () -> Unit = {},
                          onPlayed  : () -> Unit = {}): VideoPlayerType = {
                              CompositionLocalProvider(
                                  LocalThumbImageLoader provides {
                                      TorangAsyncImage(
                                          modifier = it.modifier.fillMaxSize(),
                                          model = it.url
                                      )
                                  }
                              ) {
                                  ShortItem(
                                      short = ShortVideo(id            = it.url,
                                                         videoUrl      = it.url,
                                                         thumbNailUrl  = it.url.substringBeforeLast(".") + ".jpg"),
                                      isActive = it.isPlaying,
                                      onClick = onClick,
                                      onPlayed = onPlayed
                                  )
                                  VideoPlayer(videoUrl        = it.url,
                                      playWhenReady   = it.isPlaying,
                                      onClick         = onClick,
                                      onPlayed        = onPlayed)
                              }
}