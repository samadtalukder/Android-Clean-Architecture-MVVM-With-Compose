package com.samad_talukder.mvvmcompose.ui.common.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.samad_talukder.mvvmcompose.ui.common.theme.Black

/**
 *  Copyright (C) 2024. Samad Talukder (https://www.samadtalukder.com)
 */

@Composable
fun CustomText(
    text: String,
    modifier: Modifier = Modifier,
    style: TextStyle = MaterialTheme.typography.displayLarge,
    textColor: Color = Black,
    fontSize: TextUnit = 16.sp,
    fontWeight: FontWeight = FontWeight.W400,
    lineHeight: TextUnit = fontSize * 1.5,
    letterSpacing: TextUnit = (-0.5).sp,
    maxLines: Int = Int.MAX_VALUE,
    textAlign: TextAlign = TextAlign.Start,
    textDecoration: TextDecoration = TextDecoration.None,
) {
    Text(
        text = text,
        modifier = modifier,
        style = style.copy(
            color = textColor,
            fontWeight = fontWeight,
            fontSize = fontSize,
            lineHeight = lineHeight,
            letterSpacing = letterSpacing,
            textAlign = textAlign,
            textDecoration = textDecoration
        ),
        maxLines = maxLines
    )
}