package com.darasoylu.bankappcompose.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.darasoylu.bankappcompose.presentation.card.CardScreen
import com.darasoylu.bankappcompose.presentation.card.RecentActivityDetailScreen
import com.darasoylu.bankappcompose.presentation.home.HomeScreen
import com.darasoylu.bankappcompose.presentation.menu.MenuScreen
import com.darasoylu.bankappcompose.presentation.qr.QRScreen
import com.darasoylu.bankappcompose.presentation.transfer.TransferScreen
import com.darasoylu.bankappcompose.ui.theme.BottomBarItemIndicator
import com.darasoylu.bankappcompose.ui.theme.BottomBarItemSelected
import com.darasoylu.bankappcompose.ui.theme.BottomBarItemUnSelected

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            NavigationBar(
                modifier = Modifier.height(90.dp),
                containerColor = Color.White
            ) {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination = navBackStackEntry?.destination
                listOfNavItems.forEach { navItem ->
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any { it.route == navItem.route } == true,
                        onClick = {
                            navController.navigate(navItem.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = {
                            Box(
                                modifier = if (navItem.title == "QR") {
                                    Modifier
                                        .size(50.dp)
                                        .background(
                                            BottomBarItemIndicator,
                                            shape = CircleShape,
                                        )
                                } else {
                                    Modifier
                                        .size(50.dp)
                                },
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    modifier = Modifier.size(30.dp),
                                    painter = painterResource(navItem.selectedIcon),
                                    contentDescription = null
                                )
                            }
                        },
                        colors = NavigationBarItemDefaults.colors(
                            indicatorColor = Color.Transparent,
                            unselectedIconColor = BottomBarItemUnSelected,
                            selectedIconColor = BottomBarItemSelected,
                        )
                    )
                }
            }
        }
    ) { paddingValues ->
        NavHost(
            modifier = Modifier.padding(paddingValues),
            navController = navController,
            startDestination = Routes.HOME_SCREEN
        ) {
            composable(Routes.HOME_SCREEN) {
                HomeScreen(navController)
            }

            composable(Routes.TRANSFER_SCREEN) {
                TransferScreen(navController)
            }

            composable(Routes.QR_SCREEN) {
                QRScreen()
            }

            composable(Routes.CARD_SCREEN) {
                CardScreen(navController)
            }

            composable(Routes.MENU_SCREEN) {
                MenuScreen(navController)
            }
            composable(
                route = "${Routes.RECENT_ACTIVITY_DETAIL_SCREEN}/{id}",
                arguments = listOf(navArgument("id") {
                    type = NavType.StringType
                }),
                enterTransition = {
                    return@composable slideIntoContainer(
                        AnimatedContentTransitionScope.SlideDirection.Start, tween(500)
                    )
                },
                exitTransition = {
                    return@composable slideOutOfContainer(
                        AnimatedContentTransitionScope.SlideDirection.End, tween(500)
                    )
                }
            ) { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")
                RecentActivityDetailScreen(id, onBackClick = {
                    navController.popBackStack()
                })
            }
        }
    }
}