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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samad_talukder.mvvmcompose.R
import com.samad_talukder.mvvmcompose.ui.common.components.CustomImage
import com.samad_talukder.mvvmcompose.ui.common.components.CustomText
import com.samad_talukder.mvvmcompose.ui.common.theme.ButtonColor
import com.samad_talukder.mvvmcompose.ui.common.theme.PrimaryTextColor
import com.samad_talukder.mvvmcompose.ui.common.theme.Purple40
import com.samad_talukder.mvvmcompose.ui.common.theme.White

@Composable
fun ErrorScreen(message: String, onNavigateToHome: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CustomImage(
            image = R.drawable.img_not_found,
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(26.dp))

        CustomText(
            text = "No Results",
            textColor = Purple40,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
        )

        Spacer(modifier = Modifier.height(10.dp))

        CustomText(
            text = message,
            textColor = PrimaryTextColor,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
        )

        Spacer(modifier = Modifier.height(34.dp))

        Button(
            onClick = { onNavigateToHome() },
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = ButtonColor
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = 30.dp)
        ) {
            CustomText(
                text = "Go Home",
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp,
                letterSpacing = 0.5.sp,
                textColor = White
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewErrorScreen() {
    ErrorScreen("user not found", onNavigateToHome = {})
}