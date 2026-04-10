package com.sarang.torang.di.basefeed_di

import com.example.pinchzoom.submodule.pinchzoom.PinchZoomImageData
import com.sarang.torang.compose.component.type.FeedImageLoader
import com.sarang.torang.compose.component.type.FeedImageLoaderData
import com.sarang.torang.di.pinchzoom.PinchZoomState
import com.sarang.torang.di.pinchzoom.pinchZoomImageLoader

const val tag : String = "__CustomFeedImageLoader"
fun CustomFeedImageLoader(
    zoomState   : PinchZoomState?           = null,
    onZoomState : (PinchZoomState?)->Unit   = {},
    showLog     : Boolean                   = false,
): FeedImageLoader = { data : FeedImageLoaderData ->
    pinchZoomImageLoader(
        zoomState = zoomState,
        showLog = showLog,
        onZoomState = { onZoomState.invoke(it?.copy(originHeight = data.height)) }
    ).invoke(
        PinchZoomImageData(
            modifier = data.modifier,
            model = data.url ?: "",
            contentScale = data.contentScale,
            contentDescription = null,
            height = data.height
        )
    )
}