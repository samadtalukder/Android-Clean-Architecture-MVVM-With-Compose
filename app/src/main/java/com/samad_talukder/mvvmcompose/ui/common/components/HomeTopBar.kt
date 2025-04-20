package com.samad_talukder.mvvmcompose.ui.common.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.samad_talukder.mvvmcompose.R
import com.samad_talukder.mvvmcompose.ui.common.theme.Brand60
import com.samad_talukder.mvvmcompose.ui.common.theme.GrayTextColor
import com.samad_talukder.mvvmcompose.ui.common.theme.OrangeTextColor
import com.samad_talukder.mvvmcompose.ui.common.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    topBarTitle: String,
    location: String,
    onLocationClick: () -> Unit,
    onCartItemClick: () -> Unit,
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(color = White)
    ) {

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 14.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .clickable { onLocationClick() },
                horizontalAlignment = Alignment.Start
            ) {
                CustomText(
                    topBarTitle,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    textColor = OrangeTextColor
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CustomText(
                        location,
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp,
                        textColor = GrayTextColor
                    )
                    Spacer(modifier = Modifier.padding(start = 10.dp))
                    CustomImage(image = R.drawable.ic_drop_down)
                }
            }
            Box(modifier = Modifier.clickable { onCartItemClick() }) {

                CustomImage(
                    modifier = Modifier.size(50.dp),
                    image = R.drawable.ic_nav_cart,
                )
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .offset(x = 30.dp, y = (-2).dp)
                        .clip(shape = RoundedCornerShape(20.dp))
                        .background(color = Brand60),
                    contentAlignment = Alignment.Center

                ) {
                    CustomText(
                        text = "2",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        textColor = White
                    )
                }
            }

        }

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun PreviewHomeTopBar() {
    HomeTopBar(
        topBarTitle = "Deliver To",
        location = "Dhaka",
        onLocationClick = {},
        onCartItemClick = {}
    )
}

