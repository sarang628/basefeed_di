package com.sarang.torang.di.basefeed_di

import com.sarang.torang.compose.feed.internal.components.FeedImageLoader
import com.sarang.torang.di.image.ImageLoadData
import com.sarang.torang.di.image.provideZoomableTorangAsyncImage

val CustomFeedImageLoader: FeedImageLoader = { data ->
    provideZoomableTorangAsyncImage().invoke(
        ImageLoadData(
            modifier = data.modifier,
            url = data.url,
            progressSize = data.progressSize,
            errorIconSize = data.errorIconSize,
            contentScale = data.contentScale,
            height = data.height
        )
    )
}