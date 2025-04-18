package com.samad_talukder.mvvmcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.samad_talukder.mvvmcompose.ui.common.components.ItemCategories
import com.samad_talukder.mvvmcompose.ui.common.theme.AndroidCleanArchitectureMVVMWithComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidCleanArchitectureMVVMWithComposeTheme {
                Scaffold(content = { innerPadding ->
                    LazyRow(modifier = Modifier.padding(innerPadding)) {
                        items(5) {
                            ItemCategories(
                                itemName = "Burger",
                                itemImage = R.drawable.img_burger,
                                startingPrice = "$70"
                            )
                        }
                    }
                })
            }
        }
    }
}



