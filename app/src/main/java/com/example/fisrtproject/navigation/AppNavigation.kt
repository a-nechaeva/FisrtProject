package com.example.fisrtproject.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.fisrtproject.data.local.AppData
import com.example.fisrtproject.presentation.screens.AppDetailScreen
import com.example.fisrtproject.presentation.screens.AppListScreen
import com.example.fisrtproject.presentation.viewmodels.AppListViewModel

sealed class Screen(val route: String) {
    object AppList : Screen("app_list")
    object AppDetail : Screen("app_detail/{appId}") {
        fun createRoute(appId: String) = "app_detail/$appId"
    }
}
@Composable
fun AppNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screen.AppList.route
    ) {
        composable(Screen.AppList.route) {
            val viewModel: AppListViewModel = viewModel()

            AppListScreen(
                onAppClick = { appId ->
                    navController.navigate(Screen.AppDetail.createRoute(appId))
                },
                viewModel = viewModel
            )
        }
        composable(
            route = Screen.AppDetail.route,
            arguments = listOf(
                navArgument("appId") {
                    type = NavType.StringType
                }
            )
        ) {
            backStackEntry ->
            val appId = backStackEntry.arguments?.getString("appId")?:return@composable
            val app = AppData.getAppById(appId)

            if (app != null) {
                AppDetailScreen(
                    app = app,
                    onBackClick = { navController.popBackStack() }
                )
            } else {
                AppListScreen(
                    onAppClick = { navController.popBackStack() },
                    viewModel = viewModel()
                )
            }
        }
    }
}