package com.samad_talukder.mvvmcompose.ui.common.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

/**
 *  Copyright (C) 2024. Samad Talukder (https://www.samadtalukder.com)
 */

@Composable
fun CustomImage(
    modifier: Modifier = Modifier,
    image: Int,
    contentScale: ContentScale = ContentScale.None,

    ) {
    Image(
        modifier = modifier,
        contentScale = contentScale,
        painter = painterResource(id = image),
        contentDescription = null
    )
}