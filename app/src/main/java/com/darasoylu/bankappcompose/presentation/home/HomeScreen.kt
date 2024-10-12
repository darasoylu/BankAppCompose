package com.darasoylu.bankappcompose.presentation.home

import android.util.Log
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
import com.darasoylu.bankappcompose.navigation.Routes
import com.darasoylu.bankappcompose.presentation.home.section.HomeCardSection
import com.darasoylu.bankappcompose.presentation.home.section.HomeProfileSection
import com.darasoylu.bankappcompose.presentation.home.section.HomeRecentActivitySection
import com.darasoylu.bankappcompose.presentation.home.section.HomeTransferSection

@Composable
fun HomeScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {
        HomeProfileSection()

        Spacer(modifier = Modifier.height(20.dp))

        HomeCardSection(navController)

        Spacer(modifier = Modifier.height(20.dp))

        HomeTransferSection(navController)

        Spacer(modifier = Modifier.height(20.dp))

        HomeRecentActivitySection(onItemClick = {
            navController.navigate("${Routes.RECENT_ACTIVITY_DETAIL_SCREEN}/$it")
        })
    }
}