package com.sarang.torang.di.basefeed_di

import com.sarang.torang.compose.feed.internal.components.ExpandableTextType
import com.sryang.library.ExpandableText

val CustomExpandableTextType: ExpandableTextType = { modifier, nickName, text, onClickNickName ->
    ExpandableText(modifier, nickName, text, onClickNickName)
}