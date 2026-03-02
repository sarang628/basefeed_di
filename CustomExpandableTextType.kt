package com.sarang.torang.di.basefeed_di

import com.sarang.torang.compose.feed.internal.components.type.ExpandableTextType
import com.sryang.library.ExpandableText

val CustomExpandableTextType: ExpandableTextType = {
    ExpandableText(modifier = it.modifier,
                   nickName = it.nickName,
                   text = it.contents,
                   onClickNickName = it.onNickName)
}