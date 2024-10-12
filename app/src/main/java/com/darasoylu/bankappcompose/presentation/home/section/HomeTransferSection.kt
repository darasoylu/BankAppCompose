package com.darasoylu.bankappcompose.presentation.home.section

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.darasoylu.bankappcompose.R

data class Profile(
    val profileImage: Int,
)

val profileList = listOf(
    Profile(R.drawable.ic_add),
    Profile(R.drawable.ic_face_1),
    Profile(R.drawable.ic_face_2),
    Profile(R.drawable.ic_face_4),
    Profile(R.drawable.ic_face_5),
    Profile(R.drawable.ic_face_6),
)

@Composable
fun HomeTransferSection(
    navController: NavController,
    profiles: List<Profile> = profileList
) {
    Column {
        Text(
            fontSize = 20.sp,
            text = "Transfer",
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
        )

        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                items(profiles) { profile ->
                    HomeTransferSectionCardItem(profile = profile)
                }
            }
        }
    }
}

@Composable
fun HomeTransferSectionCardItem(
    profile: Profile
) {
    Box(
        modifier = Modifier
            .size(67.dp)
            .border(2.dp, Color.Gray, CircleShape)
            .clip(CircleShape)
    ) {
        if (profile.profileImage == R.drawable.ic_add) {
            Icon(
                painter = painterResource(id = profile.profileImage),
                contentDescription = null,
                modifier = Modifier
                    .size(30.dp)
                    .align(Alignment.Center)
            )
        } else {
            Image(
                painter = painterResource(id = profile.profileImage),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}