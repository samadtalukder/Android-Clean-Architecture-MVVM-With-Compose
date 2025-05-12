package com.samad_talukder.mvvmcompose.ui.features.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.samad_talukder.mvvmcompose.R
import com.samad_talukder.mvvmcompose.ui.common.components.CustomSearchBar
import com.samad_talukder.mvvmcompose.ui.features.home.components.CategoryWithSeeAll
import com.samad_talukder.mvvmcompose.ui.features.home.components.ItemCategories
import com.samad_talukder.mvvmcompose.ui.features.home.components.ItemRestaurants

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var searchStr by remember { mutableStateOf("") }

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 16.dp)
    ) {
        item {
            CustomSearchBar(
                modifier = Modifier.padding(horizontal = 10.dp),
                value = searchStr,
                onValueChange = { searchStr = it },
                hint = "Search dishes, restaurants"
            )
        }

        item {
            Spacer(modifier = Modifier.height(30.dp))
            CategoryWithSeeAll(
                modifier = Modifier.padding(horizontal = 14.dp),
                categoryTitle = "All Categories",
                onClickSeeAll = {}
            )
            Spacer(modifier = Modifier.height(30.dp))
        }

        item {
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(5) {
                    ItemCategories(
                        itemName = "Burger",
                        itemImage = R.drawable.img_burger,
                        startingPrice = "$70"
                    )
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(30.dp))
            CategoryWithSeeAll(
                modifier = Modifier.padding(horizontal = 14.dp),
                categoryTitle = "Open Restaurants",
                onClickSeeAll = {}
            )
            Spacer(modifier = Modifier.height(30.dp))
        }

        items(5) {
            ItemRestaurants(
                modifier = Modifier.padding(horizontal = 14.dp, vertical = 12.dp),
                restaurantName = "Rose garden restaurant",
                restaurantImage = R.drawable.img_default_bg,
                restaurantRating = "4.7",
                restaurantDeliveryTime = "20 min",
                foodIngredients = "Burger - Chiken - Riche - Wings",
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewHomeScreen() {
    HomeScreen()
}