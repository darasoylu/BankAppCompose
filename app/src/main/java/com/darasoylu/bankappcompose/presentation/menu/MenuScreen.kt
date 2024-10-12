package com.darasoylu.bankappcompose.presentation.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.darasoylu.bankappcompose.R
import com.darasoylu.bankappcompose.presentation.menu.section.MenuSection

data class MenuItem(
    val title: String,
    val icon: Int,
)

val accountManagementItems = listOf(
    MenuItem("Profile", R.drawable.ic_profile),
    MenuItem("Settings", R.drawable.ic_settings),
    MenuItem("Security", R.drawable.ic_security),
)

val serviceItems = listOf(
    MenuItem("Currency", R.drawable.ic_currency),
    MenuItem("Payments", R.drawable.ic_payments),
    MenuItem("Subscriptions", R.drawable.ic_subscriptions),
)

val generalItems = listOf(
    MenuItem("Notifications", R.drawable.ic_notifications),
    MenuItem("Help", R.drawable.ic_help),
)

@Composable
fun MenuScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {
        MenuSection(title = "Account Management", menuItems = accountManagementItems)

        Spacer(modifier = Modifier.height(20.dp))

        MenuSection(title = "Services", menuItems = serviceItems)

        Spacer(modifier = Modifier.height(20.dp))

        MenuSection(title = "Generals", menuItems = generalItems)

    }
}