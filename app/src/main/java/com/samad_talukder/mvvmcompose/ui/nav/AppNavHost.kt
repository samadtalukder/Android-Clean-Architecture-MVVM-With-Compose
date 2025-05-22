/**
 * Copyright (c) 2025 Samad Talukder. All rights reserved.
 * github.com/samadtalukder
 **/
package com.samad_talukder.mvvmcompose.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.samad_talukder.mvvmcompose.ui.features.details.GithubUserDetailsScreen
import com.samad_talukder.mvvmcompose.ui.features.home.HomeScreen

@Composable
fun AppNavHost(
    navController: NavHostController = rememberNavController()
) {

    NavHost(
        navController = navController,
        startDestination = AppScreen.Home.route
    ) {
        composable(AppScreen.Home.route) {
            HomeScreen(
                onNavigateToDetails = { username ->
                    navController.navigate(AppScreen.UserDetail.userNameRoute(username))
                }
            )
        }
        composable(
            route = AppScreen.UserDetail.route,
            arguments = listOf(
                navArgument(AppScreen.UserDetail.ARG_USERNAME) {
                    type = NavType.StringType
                }
            )
        ) { backEntry ->
            val username = backEntry.arguments?.getString(AppScreen.UserDetail.ARG_USERNAME) ?: ""
            GithubUserDetailsScreen(
                onNavigateBack = { navController.popBackStack() },
                username = username,
            )
        }
    }
}
