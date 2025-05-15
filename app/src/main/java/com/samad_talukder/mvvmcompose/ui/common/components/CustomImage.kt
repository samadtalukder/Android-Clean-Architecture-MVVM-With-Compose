/**
 * Copyright (c) 2025 Samad Talukder. All rights reserved.
 * github.com/samadtalukder
 **/
package com.samad_talukder.mvvmcompose.ui.common.components

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun CustomImage(
    modifier: Modifier = Modifier,
    image: Int,
    contentScale: ContentScale = ContentScale.None,

    ) {
    Image(
        painter = painterResource(id = image),
        modifier = modifier,
        contentDescription = null,
        contentScale = contentScale,
    )
}