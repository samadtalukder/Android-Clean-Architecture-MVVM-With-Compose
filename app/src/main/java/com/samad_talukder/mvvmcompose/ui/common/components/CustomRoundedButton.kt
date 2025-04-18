package com.samad_talukder.mvvmcompose.ui.common.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samad_talukder.mvvmcompose.ui.common.theme.Brand60
import com.samad_talukder.mvvmcompose.ui.common.theme.Grey60
import com.samad_talukder.mvvmcompose.ui.common.theme.White


/**
 *  Copyright (C) 2024. Samad Talukder (https://www.samadtalukder.com)
 */

@Composable
fun CustomRoundedButton(
    modifier: Modifier = Modifier,
    text: String,
    isActive: Boolean = false,
    onClick: () -> Unit,
    height: Dp = 54.dp,
) {
    Button(
        onClick = { onClick() },
        enabled = isActive,
        modifier = modifier
            .fillMaxWidth()
            .height(height),
        shape = RoundedCornerShape(28.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Brand60
        )
    ) {
        CustomText(
            text = text,
            textColor = if (isActive) White else Grey60,
            fontSize = 16.sp,
            fontWeight = FontWeight.W600,
            lineHeight = 22.sp,
            letterSpacing = (-0.4).sp
        )
    }
}