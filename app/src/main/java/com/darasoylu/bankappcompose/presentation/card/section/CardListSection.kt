package com.darasoylu.bankappcompose.presentation.card.section

import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.darasoylu.bankappcompose.R
import com.darasoylu.bankappcompose.presentation.home.section.HomeRecentActivitySectionCardItem
import kotlinx.coroutines.launch

data class MyCard(
    val id: String,
    val number: String,
    val type: String,
    val expiryDate: String,
    val cardType: String,
    val image: Int
)

val myCardList = listOf(
    MyCard("1", "**** 1839", "Physical", "07/28", "visa", R.drawable.gradient_black),
    MyCard("2", "**** 3058", "Physical", "04/22", "mastercard", R.drawable.gradient_black),
    MyCard("3", "**** 5830", "Physical", "10/08", "visa", R.drawable.gradient_black),
    MyCard("4", "**** 7756", "Virtual", "11/01", "visa", R.drawable.gradient_black),
    MyCard("4", "**** 8612", "Virtual", "12/02", "mastercard", R.drawable.gradient_black)
)

enum class CardListTabs(
    val title: String
) {
    PHYSICAL("Physical"),
    VIRTUAL("Virtual")
}

@Composable
fun CardListSection(
    cards: List<MyCard> = myCardList
) {

    val coroutineScope = rememberCoroutineScope()
    val pagerState = rememberPagerState { CardListTabs.entries.size }
    val selectedTabIndex = remember { derivedStateOf { pagerState.currentPage } }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            fontSize = 20.sp,
            text = "My Cards",
            fontWeight = FontWeight.Bold,
            color = Color.Black,
        )

        Spacer(modifier = Modifier.height(20.dp))

        TabRow(
            selectedTabIndex = selectedTabIndex.value,
            indicator = { },
            divider = { },
        ) {
            CardListTabs.entries.forEachIndexed { index, tab ->
                Tab(
                    modifier = Modifier
                        .background(Color.White),
                    selected = index == selectedTabIndex.value,
                    onClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(
                                page = index,
                                animationSpec = tween(durationMillis = 500)
                            )
                        }
                    },
                    selectedContentColor = Color.White
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        border = BorderStroke(
                            1.dp,
                            if (selectedTabIndex.value == index) Color.Black else Color(0xFFE0DDDD)
                        ),
                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 2.dp
                        ),
                        colors = CardDefaults.cardColors(
                            containerColor = if (selectedTabIndex.value == index) Color.Black else Color.White
                        ),
                    ) {
                        Text(
                            text = tab.title,
                            fontWeight = FontWeight.Bold,
                            color = if (selectedTabIndex.value == index) Color.White else Color.Black,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                }
            }
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            pageSpacing = 10.dp
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    items(cards
                        .filter { it.type == CardListTabs.entries[pagerState.currentPage].title }
                    ) { card ->
                        CardListSectionCardItem(card)
                    }
                }
            }
        }
    }
}

@Composable
fun CardListSectionCardItem(
    card: MyCard
) {
    Card(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(card.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                Spacer(modifier = Modifier.height(50.dp))

                Text(
                    text = card.number,
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = card.expiryDate,
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Thin
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Image(
                        painter = painterResource(id = if (card.cardType == "visa") R.drawable.ic_visa else R.drawable.ic_mastercard),
                        contentDescription = null,
                        modifier = Modifier
                            .size(120.dp),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }
}
