package com.samad_talukder.mvvmcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.samad_talukder.mvvmcompose.ui.common.components.HomeTopBar
import com.samad_talukder.mvvmcompose.ui.common.theme.AndroidCleanArchitectureMVVMWithComposeTheme
import com.samad_talukder.mvvmcompose.ui.features.home.HomeScreen

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            AndroidCleanArchitectureMVVMWithComposeTheme {

                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .statusBarsPadding(),
                    topBar = {
                        HomeTopBar(
                            topBarTitle = "Deliver To",
                            location = "Dhaka",
                            onLocationClick = {},
                            onCartItemClick = {}
                        )
                    },
                    content = { innerPadding ->
                        HomeScreen(modifier = Modifier.padding(innerPadding))
                    }
                )
            }
        }
    }
}



