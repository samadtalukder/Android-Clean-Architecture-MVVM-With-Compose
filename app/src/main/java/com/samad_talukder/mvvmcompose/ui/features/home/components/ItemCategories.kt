package com.samad_talukder.mvvmcompose.ui.features.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samad_talukder.mvvmcompose.R
import com.samad_talukder.mvvmcompose.ui.common.components.CustomImage
import com.samad_talukder.mvvmcompose.ui.common.components.CustomText
import com.samad_talukder.mvvmcompose.ui.common.theme.Black
import com.samad_talukder.mvvmcompose.ui.common.theme.PrimaryTextColor
import com.samad_talukder.mvvmcompose.ui.common.theme.SecondaryTextColor
import com.samad_talukder.mvvmcompose.ui.common.theme.White


/**
 *  Copyright (C) 2024. Samad Talukder (https://www.samadtalukder.com)
 */

@Composable
fun ItemCategories(
    itemName: String,
    itemImage: Int,
    startingPrice: String,
) {
    Box(
        modifier = Modifier
            .width(160.dp)
            .height(220.dp)
            .padding(8.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(24.dp))
                .background(White)
                .shadow(
                    elevation = 10.dp,
                    shape = RoundedCornerShape(24.dp),
                    ambientColor = Black.copy(alpha = 0.05f),
                    spotColor = Black.copy(alpha = 0.05f)
                )
                .padding(top = 70.dp, bottom = 20.dp, start = 16.dp, end = 16.dp)
        ) {
            Column {
                CustomText(
                    text = itemName,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    textColor = PrimaryTextColor
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    CustomText(
                        text = "Starting",
                        textColor = SecondaryTextColor,
                        fontSize = 14.sp
                    )
                    CustomText(
                        text = startingPrice,
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        textColor = PrimaryTextColor
                    )
                }
            }
        }

        CustomImage(
            image = itemImage,
            modifier = Modifier
                .size(120.dp)
                .offset(y = (-20).dp),
            contentScale = ContentScale.Fit
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewItemCategories() {
    LazyRow {
        items(5) {
            ItemCategories(
                itemName = "Burger",
                itemImage = R.drawable.img_burger,
                startingPrice = "$70"
            )
        }
    }
}