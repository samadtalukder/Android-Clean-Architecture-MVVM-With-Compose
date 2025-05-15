/**
 * Copyright (c) 2025 Samad Talukder. All rights reserved.
 * github.com/samadtalukder
 **/
package com.samad_talukder.mvvmcompose.ui.nav


sealed class AppScreen(val route: String) {
    object Home : AppScreen("home")
    object UserDetail : AppScreen("user_detail/{username}") {
        const val ARG_USERNAME = "username"
        fun userNameRoute(username: String): String = "user_detail/$username"
    }

}
