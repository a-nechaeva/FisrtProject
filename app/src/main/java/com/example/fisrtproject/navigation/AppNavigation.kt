package com.example.fisrtproject.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.fisrtproject.presentation.screens.AppDetailScreen
import com.example.fisrtproject.presentation.screens.AppListScreen
import com.example.fisrtproject.presentation.viewmodels.AppDetailViewModel
import com.example.fisrtproject.presentation.viewmodels.AppListViewModel

sealed class Screen(val route: String) {
    object AppList : Screen("app_list")
    object AppDetail : Screen("app_detail/{appId}") {
        fun createRoute(appId: String) = "app_detail/$appId"
    }
}
@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.AppList.route
    ) {
        composable(Screen.AppList.route) {
            val viewModel : AppListViewModel = hiltViewModel()

            AppListScreen(
                onAppClick = { appId ->
                    navController.navigate(Screen.AppDetail.createRoute(appId))
                },
                viewModel = viewModel
            )
        }
        composable(Screen.AppDetail.route) { backStackEntry ->
            val appId = backStackEntry.arguments?.getString("appId") ?: return@composable
            val viewModel: AppDetailViewModel = hiltViewModel()

            viewModel.fetchAppDetails(appId)

            AppDetailScreen(
                viewModel = viewModel,
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}