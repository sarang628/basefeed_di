package com.sarang.torang.di.basefeed_di

import com.sarang.torang.BuildConfig
import com.sarang.torang.core.database.model.feed.ReviewAndImageEntity
import com.sarang.torang.data.basefeed.FeedItemUiState

fun ReviewAndImageEntity.toReview(): FeedItemUiState {
    return FeedItemUiState(
        reviewImages        = this.images.map { BuildConfig.REVIEW_IMAGE_SERVER_URL + it.pictureUrl },
        userName            = this.review.userName ?: "",
        profilePictureUrl   = BuildConfig.PROFILE_IMAGE_SERVER_URL + this.review.profilePicUrl,
        restaurantName      = this.review.restaurantName ?: "",
        rating              = this.review.rating ?: 0f,
        likeAmount          = this.review.likeAmount ?: 0,
        commentAmount       = this.review.commentAmount ?: 0,
        comments            = listOf(),
        isLike              = this.like != null,
        isFavorite          = this.favorite != null,
        contents            = this.review.contents ?: "",
        height              = if(images.isEmpty()) 300 else this.images[0].height ?: 0,
        width               = if(images.isEmpty()) 300 else this.images[0].width ?: 0,
        createDate          = this.review.createDate ?: ""
    )
}