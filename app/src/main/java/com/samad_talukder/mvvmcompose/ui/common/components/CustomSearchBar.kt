package com.samad_talukder.mvvmcompose.ui.common.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samad_talukder.mvvmcompose.R
import com.samad_talukder.mvvmcompose.ui.common.theme.GrayTextColor

/**
 *  Copyright (C) 2024. Samad Talukder (https://www.samadtalukder.com)
 */

@Composable
fun CustomSearchBar(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    hint: String,
) {

    Surface(
        tonalElevation = 4.dp,
        shape = RoundedCornerShape(10.dp),
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)

    ) {
        Row(
            modifier = Modifier
                .height(56.dp)
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            CustomImage(
                image = R.drawable.ic_search,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(16.dp)
            )
            Box(
                modifier = Modifier.weight(1f),
                contentAlignment = Alignment.CenterStart
            ) {
                BasicTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = value,
                    onValueChange = onValueChange,
                    enabled = true,
                    textStyle = TextStyle(
                        color = GrayTextColor,
                        textAlign = TextAlign.Start
                    ),

                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text
                    ),
                    singleLine = true,

                    )

                if (value.isEmpty()) {
                    CustomText(
                        text = hint,
                        textColor = GrayTextColor,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                    )
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewCustomSearchBar() {
    CustomSearchBar(
        value = "",
        onValueChange = {},
        hint = "Search dishes, restaurants"
    )
}