package com.sarang.torang.di.basefeed_di

import com.sarang.torang.BuildConfig
import com.sarang.torang.compose.feed.FeedBottomUiState
import com.sarang.torang.compose.feed.FeedItemUiState
import com.sarang.torang.compose.feed.FeedTopUiState
import com.sarang.torang.data.ReviewAndImage

fun ReviewAndImage.toReview(): FeedItemUiState {
    return FeedItemUiState(
        reviewImages        = this.images.map { BuildConfig.REVIEW_IMAGE_SERVER_URL + it.pictureUrl },
        feedTopUiState = FeedTopUiState(userName            = this.review.userName ?: "",
                                        profilePictureUrl   = BuildConfig.PROFILE_IMAGE_SERVER_URL + this.review.profilePicUrl,
                                        restaurantName      = this.review.restaurantName ?: "",
                                        rating              = this.review.rating ?: 0f,),
        commentAmount       = this.review.commentAmount ?: 0,
        comments            = listOf(),
        feedBottomUiState = FeedBottomUiState(
            likeAmount = this.review.likeAmount ?: 0,
            isLike = this.like != null,
            isFavorite = this.favorite != null,
        ),
        contents            = this.review.contents ?: "",
        height              = if(images.isEmpty()) 300 else this.images[0].height ?: 0,
        width               = if(images.isEmpty()) 300 else this.images[0].width ?: 0,
        createDate          = this.review.createDate ?: ""
    )
}