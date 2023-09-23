package com.example.bankappchallenge.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bankappchallenge.R

@Composable
fun MyCardsRow(modifier: Modifier = Modifier) {
    LazyRow(
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier
    ) {
        items(5) {
            MyCardsItem(index = it)
        }
    }
}

@Composable
fun MyCardsItem(modifier: Modifier = Modifier, index: Int = 0) {
    ElevatedCard(
        colors = CardDefaults.cardColors(
            containerColor = if (index % 2 == 0) MaterialTheme.colorScheme.secondary else Color.Black,
            contentColor = MaterialTheme.colorScheme.primary
        ),
        modifier = modifier
            .width(312.dp)
            .height(168.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_mastercard),
                    contentDescription = null
                )
                Text(
                    text = "**** 2141",
                    style = MaterialTheme.typography.labelMedium.copy(fontSize = 16.sp),
                    modifier = Modifier
                        .padding(start = 16.dp)
                        .weight(1f)
                )
                Text(text = "02/24", style = MaterialTheme.typography.labelMedium)
            }

            Column(
                modifier = Modifier
            ) {
                Text(text = "Balance", style = MaterialTheme.typography.labelMedium)
                Text(
                    text = "$ 5 300.00",
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}
