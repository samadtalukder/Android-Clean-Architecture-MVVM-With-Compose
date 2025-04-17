package com.samad_talukder.mvvmcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.samad_talukder.mvvmcompose.ui.theme.AndroidCleanArchitectureMVVMWithComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidCleanArchitectureMVVMWithComposeTheme {
                /*Scaffold(modifier = Modifier.fillMaxSize()) {

                }*/
            }
        }
    }
}