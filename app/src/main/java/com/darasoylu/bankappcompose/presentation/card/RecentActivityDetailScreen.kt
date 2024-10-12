package com.darasoylu.bankappcompose.presentation.card

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darasoylu.bankappcompose.R

data class RecentActivityDetail(
    val id: Int,
    val date: String,
    val time: String,
    val title: String,
    val amount: String,
    val description: String,
    val type: String,
    val status: Boolean,
)

val recentActivityDetail = RecentActivityDetail(
    id = 18445748,
    date = "2024-10-04",
    time = "10:12",
    title = "Spotify",
    amount = "$10",
    description = "Spotify Premium",
    type = "Entertainment",
    status = true,
)

@Composable
fun RecentActivityDetailScreen(
    id: String?,
    onBackClick: () -> Unit,
    detail: RecentActivityDetail = recentActivityDetail
) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 16.dp),
    ) {
        IconButton(
            modifier = Modifier
                .size(40.dp),
            onClick = {
                onBackClick()
            },
        ) {
            Icon(
                modifier = Modifier
                    .fillMaxSize(),
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "back",
            )
        }

        Spacer(modifier = Modifier.height(50.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier
                    .size(100.dp),
                painter = if (detail.status) painterResource(id = R.drawable.ic_success) else painterResource(id = R.drawable.ic_fail),
                contentDescription = if (detail.status) "success" else "fail",
                tint = Color.Unspecified
            )
        }

        Spacer(modifier = Modifier.height(50.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White),
            border = BorderStroke(1.dp, Color(0xFFE0DDDD)),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 16.dp)
            ) {
                Text(
                    modifier = Modifier,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    text = "Payment Detail",
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(30.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier,
                        text = "Payment ID",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Thin
                    )
                    Text(
                        modifier = Modifier,
                        text = detail.id.toString(),
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier,
                        text = "Date",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Thin
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Text(
                        modifier = Modifier,
                        text = detail.time,
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Text(
                        modifier = Modifier,
                        text = " / ",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )

                    Text(
                        modifier = Modifier,
                        text = detail.date,
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier,
                        text = "Title",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Thin
                    )
                    Text(
                        modifier = Modifier,
                        text = detail.title,
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier,
                        text = "Amount",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Thin
                    )
                    Text(
                        modifier = Modifier,
                        text = detail.amount,
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier,
                        text = "Description",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Thin
                    )
                    Text(
                        modifier = Modifier,
                        text = detail.description,
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier,
                        text = "Type",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Thin
                    )
                    Text(
                        modifier = Modifier,
                        text = detail.type,
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}











