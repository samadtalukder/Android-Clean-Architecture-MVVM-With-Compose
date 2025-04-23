package com.samad_talukder.mvvmcompose.ui.features.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samad_talukder.mvvmcompose.R
import com.samad_talukder.mvvmcompose.ui.common.components.CustomImage
import com.samad_talukder.mvvmcompose.ui.common.components.CustomText
import com.samad_talukder.mvvmcompose.ui.common.theme.PrimaryTextColor
import com.samad_talukder.mvvmcompose.ui.common.theme.SeeAllTextColor

@Composable
fun CategoryWithSeeAll(
    modifier: Modifier = Modifier,
    categoryTitle: String,
    onClickSeeAll: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        CustomText(
            text = categoryTitle,
            textColor = PrimaryTextColor,
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable { onClickSeeAll() },
        ) {
            CustomText(
                text = "See All",
                textColor = SeeAllTextColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
            Spacer(modifier = Modifier.width(6.dp))
            CustomImage(modifier = Modifier.size(10.dp), image = R.drawable.ic_forward)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewCategoryWithSeeAll() {
    CategoryWithSeeAll(categoryTitle = "All Categories", onClickSeeAll = {})
}