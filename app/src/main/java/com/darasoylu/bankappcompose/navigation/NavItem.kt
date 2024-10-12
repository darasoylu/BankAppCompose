package com.darasoylu.bankappcompose.navigation

import com.darasoylu.bankappcompose.R

data class NavItem(
    val route: String,
    val title: String,
    val selectedIcon: Int,
    val unSelectedIcon: Int
)

val listOfNavItems = listOf(
    NavItem(
        route = "HOME",
        title = "HOME",
        selectedIcon = R.drawable.ic_home,
        unSelectedIcon = R.drawable.ic_home
    ),
    NavItem(
        route = "TRANSFER",
        title = "TRANSFER",
        selectedIcon = R.drawable.ic_transfer,
        unSelectedIcon = R.drawable.ic_transfer
    ),
    NavItem(
        route = "QR",
        title = "QR",
        selectedIcon = R.drawable.ic_qr_code,
        unSelectedIcon = R.drawable.ic_qr_code
    ),
    NavItem(
        route = "CARD",
        title = "CARD",
        selectedIcon = R.drawable.ic_card,
        unSelectedIcon = R.drawable.ic_card
    ),
    NavItem(
        route = "MENU",
        title = "MENU",
        selectedIcon = R.drawable.ic_menu,
        unSelectedIcon = R.drawable.ic_menu
    )
)