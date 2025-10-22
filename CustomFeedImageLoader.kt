package com.sarang.torang.di.basefeed_di

import com.example.pinchzoom.library.pinchzoom.rememberPinchZoomState
import com.example.pinchzoom.submodule.pinchzoom.PunchZoomImageData
import com.sarang.torang.compose.feed.internal.components.FeedImageLoader
import com.sarang.torang.di.image.ImageLoadData
import com.sarang.torang.di.image.provideZoomableTorangAsyncImage
import com.sarang.torang.di.pinchzoom.PinchZoomState
import com.sarang.torang.di.pinchzoom.pinchZoomImageLoader

fun CustomFeedImageLoader(
    zoomState: PinchZoomState?,
    onZoomState : (PinchZoomState?)->Unit  ={},
    showLog     : Boolean = false,
): FeedImageLoader = { data ->

    pinchZoomImageLoader(
        zoomState = zoomState,
        showLog = showLog,
        onZoomState = onZoomState
    ).invoke(
        PunchZoomImageData(
            modifier = data.modifier,
            model = data.url ?: "",
            contentScale = data.contentScale,
            contentDescription = null
        )
    )

    /*provideZoomableTorangAsyncImage().invoke(
        ImageLoadData(
            modifier = data.modifier,
            url = data.url,
            progressSize = data.progressSize,
            errorIconSize = data.errorIconSize,
            contentScale = data.contentScale,
            height = data.height
        )
    )*/
}