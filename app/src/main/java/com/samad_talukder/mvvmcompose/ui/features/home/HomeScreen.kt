package com.samad_talukder.mvvmcompose.ui.features.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.samad_talukder.mvvmcompose.R
import com.samad_talukder.mvvmcompose.ui.common.components.ItemCategories
import com.samad_talukder.mvvmcompose.ui.common.components.ItemRestaurants

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column {
        Spacer(
            modifier = modifier
        )
        LazyRow {
            items(5) {
                ItemCategories(
                    itemName = "Burger",
                    itemImage = R.drawable.img_burger,
                    startingPrice = "$70"
                )
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn {
            items(5) {
                ItemRestaurants(
                    restaurantName = "Rose garden restaurant",
                    restaurantImage = R.drawable.img_default_bg,
                    restaurantRating = "4.7",
                    restaurantDeliveryTime = "20 min",
                    foodIngredients = "Burger - Chiken - Riche - Wings",
                )
            }
        }
    }
}