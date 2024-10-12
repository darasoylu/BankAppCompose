package com.darasoylu.bankappcompose.presentation.home.section

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.darasoylu.bankappcompose.R

data class RecentActivity(
    val name: String,
    val date: String,
    val image: Int,
    val amount: String,
)

val recentActivityList = listOf(
    RecentActivity("Spotify", "2024-10-04", R.drawable.ic_spotify, "$10"),
    RecentActivity("Youtube", "2024-10-04", R.drawable.ic_youtube, "$18"),
    RecentActivity("Amazon", "2024-10-02", R.drawable.ic_amazon, "$244"),
    RecentActivity("Disney+", "2024-09-30", R.drawable.ic_disneyplus, "$9"),
    RecentActivity("Netflix", "2024-09-29", R.drawable.ic_netflix, "$27"),
)

@Composable
fun HomeRecentActivitySection(
    onItemClick: (String) -> Unit,
    recentActivities: List<RecentActivity> = recentActivityList
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            fontSize = 20.sp,
            text = "Recent Activities",
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
        )

        Spacer(modifier = Modifier.height(10.dp))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(recentActivities) { recentActivity ->
                    HomeRecentActivitySectionCardItem(
                        onCardClick = onItemClick,
                        recentActivity = recentActivity
                    )
                }
            }
        }
    }
}

@Composable
fun HomeRecentActivitySectionCardItem(
    onCardClick: (String) -> Unit,
    recentActivity: RecentActivity
) {
    Card(
        modifier = Modifier
            .height(108.dp)
            .fillMaxWidth()
            .background(Color.White),
        border = BorderStroke(1.dp, Color(0xFFE0DDDD)),
        shape = RoundedCornerShape(30.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        onClick = {
            onCardClick(recentActivity.name)
        }
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                painter = painterResource(id = recentActivity.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(90.dp)
                    .padding(5.dp)
            )

            Column(
                modifier = Modifier
            ) {
                Text(
                    text = recentActivity.name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.Black,
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = recentActivity.date,
                    fontSize = 16.sp,
                    color = Color.Gray,
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                modifier = Modifier
                    .padding(end = 20.dp),
                text = "-" + recentActivity.amount,
                fontSize = 22.sp,
                fontWeight = FontWeight.SemiBold,
            )
        }
    }
}





