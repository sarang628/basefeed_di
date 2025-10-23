package com.sarang.torang.di.basefeed_di

import androidx.compose.ui.unit.dp
import com.example.pinchzoom.submodule.pinchzoom.PinchZoomImageData
import com.sarang.torang.compose.feed.internal.components.FeedImageLoader
import com.sarang.torang.compose.feed.internal.components.FeedImageLoaderData
import com.sarang.torang.di.pinchzoom.PinchZoomState
import com.sarang.torang.di.pinchzoom.d
import com.sarang.torang.di.pinchzoom.pinchZoomImageLoader

fun CustomFeedImageLoader(
    tag         : String                    = "__CustomFeedImageLoader",
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