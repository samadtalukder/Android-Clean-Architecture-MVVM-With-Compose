/**
 * Copyright (c) 2025 Samad Talukder. All rights reserved.
 * github.com/samadtalukder
 **/
package com.samad_talukder.mvvmcompose.ui.features.details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samad_talukder.mvvmcompose.ui.common.components.CustomText
import com.samad_talukder.mvvmcompose.ui.common.theme.OrangeTextColor

@Composable
fun LoadingScreen() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(48.dp),
            color = OrangeTextColor
        )

        Spacer(modifier = Modifier.height(16.dp))

        CustomText(
            text = "Loading user details...",
            textColor = OrangeTextColor,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}